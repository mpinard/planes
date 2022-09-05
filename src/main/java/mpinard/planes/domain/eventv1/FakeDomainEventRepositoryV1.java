package mpinard.planes.domain.eventv1;

import lombok.NoArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@NoArgsConstructor
public class FakeDomainEventRepositoryV1 implements DomainEventRepositoryV1 {
    private final List<DomainEventV1<?>> savedEvents = new LinkedList<>();
    private final Sinks.Many<DomainEventV1<?>> sink = Sinks.many().unicast().onBackpressureBuffer();
    private final Lock lock = new ReentrantLock();
    private long nextSequenceNumber = 1L;

    @Override
    public void replaySavedEvents() {
        savedEvents.stream()
            .map(event -> (DomainEventV1<?>) event.withReplay(true))
            .forEach(this::notify);
    }

    @Override
    public <E extends DomainEventV1<E>> DomainEventV1<E> save(DomainEventV1<E> event) {
        DomainEventV1<E> savedEvent = doSave(event);
        notify(savedEvent);

        return savedEvent;
    }

    @Override
    public Flux<DomainEventV1<?>> streamEvents() {
        return sink.asFlux();
    }

    @SuppressWarnings("unchecked")
    public void loadEvents(List<DomainEventV1<?>> eventsToLoad) {
        eventsToLoad.forEach(event -> doSave(event.getClass().cast(event)));
    }

    public void close() {
        sink.tryEmitComplete();
    }

    private <E extends DomainEventV1<E>> DomainEventV1<E> doSave(DomainEventV1<E> event) {
        final DomainEventV1<E> savedEvent;

        lock.lock();
        try {
            savedEvent = event.withSequenceNumber(nextSequenceNumber++);
            savedEvents.add(savedEvent);
        } finally {
            lock.unlock();
        }

        return savedEvent;

    }

    private void notify(DomainEventV1<?> event) {
        sink.tryEmitNext(event);
    }

}

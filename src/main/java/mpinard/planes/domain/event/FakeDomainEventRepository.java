package mpinard.planes.domain.event;

import lombok.NoArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@NoArgsConstructor
public class FakeDomainEventRepository implements DomainEventRepository {
    private final List<DomainEvent<?>> savedEvents = new LinkedList<>();
    private final Sinks.Many<DomainEvent<?>> sink = Sinks.many().unicast().onBackpressureBuffer();
    private final Lock lock = new ReentrantLock();
    private long nextSequenceNumber = 1L;

    @Override
    public void replaySavedEvents() {
        savedEvents.stream()
            .map(event -> (DomainEvent<?>) event.withReplay(true))
            .forEach(this::notify);
    }

    @Override
    public <E extends DomainEvent<E>> DomainEvent<E> save(DomainEvent<E> event) {
        DomainEvent<E> savedEvent = doSave(event);
        notify(savedEvent);

        return savedEvent;
    }

    @Override
    public Flux<DomainEvent<?>> streamEvents() {
        return sink.asFlux();
    }

    @SuppressWarnings("unchecked")
    public void loadEvents(List<DomainEvent<?>> eventsToLoad) {
        eventsToLoad.forEach(event -> doSave(event.getClass().cast(event)));
    }

    public void close() {
        sink.tryEmitComplete();
    }

    private <E extends DomainEvent<E>> DomainEvent<E> doSave(DomainEvent<E> event) {
        final DomainEvent<E> savedEvent;

        lock.lock();
        try {
            savedEvent = event.withSequenceNumber(nextSequenceNumber++);
            savedEvents.add(savedEvent);
        } finally {
            lock.unlock();
        }

        return savedEvent;

    }

    private void notify(DomainEvent<?> event) {
        sink.tryEmitNext(event);
    }

}

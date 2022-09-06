package mpinard.planes.domain.event;

import lombok.NoArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@NoArgsConstructor(staticName = "of")
public class FakeDomainEventRepository implements DomainEventRepository {

    private final List<DomainEvent<?>> savedEvents = new LinkedList<>();
    private final Lock lock = new ReentrantLock();
    private long nextSequenceNumber = 1L;

    @Override
    public <E extends DomainEvent<E>> Optional<DomainEvent<E>> save(DomainEvent<E> event) {
        final DomainEvent<E> savedEvent;

        lock.lock();
        try {
            if (savedEvents.stream().anyMatch(eachEvent -> eachEvent.getId().equals(event.getId()))) {
                return Optional.empty();
            }

            savedEvent = event.withSequenceNumber(nextSequenceNumber++);
            savedEvents.add(savedEvent);
        } finally {
            lock.unlock();
        }

        return Optional.of(savedEvent);
    }

    @Override
    public Flux<DomainEvent<?>> eventsAfter(EventId eventId) {
        final List<DomainEvent<?>> copyOfSavedEvents;

        lock.lock();
        try {
            copyOfSavedEvents = List.copyOf(savedEvents);
        } finally {
            lock.unlock();
        }

        return Flux.fromIterable(copyOfSavedEvents)
            .skipUntil(event -> eventId == null || eventId.equals(event.getId()))
            .filter(event -> eventId == null || !eventId.equals(event.getId()));
    }

}

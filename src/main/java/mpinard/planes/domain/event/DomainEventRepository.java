package mpinard.planes.domain.event;

import reactor.core.publisher.Flux;

import java.util.Optional;

public interface DomainEventRepository {

    /**
     * Saves the event if no event with the save EventId has already been saved.
     *
     * @param event the event to save
     * @return an optional wrapping the saved event with updated sequence number, or empty if there was already a saved
     * @param <E> the concrete subtype of {@code event}
     */
    <E extends DomainEvent<E>> Optional<DomainEvent<E>> save(DomainEvent<E> event);

    /**
     * Returns a Flux of all events sequentially after the event with the passed EventId, not including the event with matching EventId.  If
     * the argument is null or does not match any of the saved events, a Flux of all events are returned.
     *
     * @param eventId the eventId of the event for which it and all prior events should be excluded from the result
     * @return a Flux over all events after the event with the passed id
     */
    Flux<DomainEvent<?>> eventsAfter(EventId eventId);
}

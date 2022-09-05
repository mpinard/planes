package mpinard.planes.domain.event;

import reactor.core.publisher.Flux;

public interface DomainEventRepository {

    void replayEvents();

    <E extends DomainEvent<E>> DomainEvent<E> save(DomainEvent<E> event);

    Flux<DomainEvent<?>> streamEvents();

}

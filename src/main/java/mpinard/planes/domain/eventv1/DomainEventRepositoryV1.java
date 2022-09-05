package mpinard.planes.domain.eventv1;

import reactor.core.publisher.Flux;

public interface DomainEventRepositoryV1 {

    void replaySavedEvents();

    <E extends DomainEventV1<E>> DomainEventV1<E> save(DomainEventV1<E> event);

    Flux<DomainEventV1<?>> streamEvents();

}

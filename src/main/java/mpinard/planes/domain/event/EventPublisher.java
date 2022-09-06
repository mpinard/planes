package mpinard.planes.domain.event;

import java.util.Optional;

public interface EventPublisher {

    void publish(ApplicationEvent event);

    <E extends DomainEvent<E>> Optional<DomainEvent<E>> publish(DomainEvent<E> event);
}

package mpinard.planes.domain.event;

import java.util.function.Consumer;

public interface DomainEventPublisher {

    DomainEventSubscriptionId subscribe(DomainEventType eventType, Consumer<? super DomainEvent<?>> consumer);

    <E extends DomainEvent<E>> DomainEvent<E> publish(DomainEvent<E> event);

}

package mpinard.planes.domain.eventv1;

import java.util.function.Consumer;

public interface DomainEventPublisherV1 {

    DomainEventSubscriptionId subscribe(DomainEventTypeV1 eventType, Consumer<? super DomainEventV1<?>> consumer);

    <E extends DomainEventV1<E>> DomainEventV1<E> publish(DomainEventV1<E> event);

}

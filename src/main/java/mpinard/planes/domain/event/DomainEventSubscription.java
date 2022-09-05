package mpinard.planes.domain.event;

import lombok.Value;
import lombok.With;

import java.util.function.Consumer;

@Value(staticConstructor = "of")
public class DomainEventSubscription {
    private DomainEventSubscriptionId id;
    private Consumer<? super DomainEvent<?>> eventConsumer;
    @With
    private Long lastDeliveredSequenceNumber;

    public static DomainEventSubscription of(DomainEventSubscriptionId id, Consumer<? super DomainEvent<?>> eventConsumer) {
        return DomainEventSubscription.of(id, eventConsumer, null);
    }

    public void notify(DomainEvent<?> event) {
        eventConsumer.accept(event);
    }
}

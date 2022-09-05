package mpinard.planes.domain.eventv1;

import lombok.Value;
import lombok.With;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

@Value(staticConstructor = "of")
@Slf4j
public class DomainEventSubscriptionV1 {

    DomainEventSubscriptionId id;
    Consumer<? super DomainEventV1<?>> eventConsumer;
    @With
    Long lastDeliveredSequenceNumber;

    public static DomainEventSubscriptionV1 of(DomainEventSubscriptionId id, Consumer<? super DomainEventV1<?>> eventConsumer) {
        return DomainEventSubscriptionV1.of(id, eventConsumer, null);
    }

    public void notify(DomainEventV1<?> event) {
        try {
            eventConsumer.accept(event);
        } catch (RuntimeException e) {
            log.error("Error processing event {}", event, e);
        }
    }
}

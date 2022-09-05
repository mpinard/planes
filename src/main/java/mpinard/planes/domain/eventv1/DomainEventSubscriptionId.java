package mpinard.planes.domain.eventv1;

import java.util.UUID;

public record DomainEventSubscriptionId(UUID id) {

    public static DomainEventSubscriptionId of() {
        return new DomainEventSubscriptionId(UUID.randomUUID());
    }
}

package mpinard.planes.domain.event;

import java.util.UUID;

public record DomainEventSubscriptionId(UUID id) {

    public static DomainEventSubscriptionId of() {
        return new DomainEventSubscriptionId(UUID.randomUUID());
    }
}

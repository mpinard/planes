package mpinard.planes.domain.event;

import java.util.UUID;

public record DomainEventId(UUID id) {

    public static DomainEventId of() {
        return new DomainEventId(UUID.randomUUID());
    }
}

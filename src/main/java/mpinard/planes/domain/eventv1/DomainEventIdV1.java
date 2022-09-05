package mpinard.planes.domain.eventv1;

import java.util.UUID;

public record DomainEventIdV1(UUID id) {

    public static DomainEventIdV1 of() {
        return new DomainEventIdV1(UUID.randomUUID());
    }
}

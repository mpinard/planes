package mpinard.planes.domain.event;

import java.util.UUID;

public record EventId(UUID id) {

    public static EventId of() {
        return new EventId(UUID.randomUUID());
    }
}

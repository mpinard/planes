package mpinard.planes.domain.plane;

import java.util.UUID;

public record PlaneId(UUID id) {

    public static PlaneId of() {
        return new PlaneId(UUID.randomUUID());
    }

}

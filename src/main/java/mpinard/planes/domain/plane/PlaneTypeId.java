package mpinard.planes.domain.plane;

import java.util.UUID;

public record PlaneTypeId(UUID id) {

    public static PlaneTypeId of() {
        return new PlaneTypeId(UUID.randomUUID());
    }

}

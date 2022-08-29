package mpinard.planes.adapter.domain.plane;

import lombok.Value;

import java.util.UUID;

@Value(staticConstructor = "of")
public class PlaneId {
    private UUID id;

    public static PlaneId of() {
        return of(UUID.randomUUID());
    }
}

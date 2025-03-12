package mpinard.planes.domain.plane;

import com.github.f4b6a3.uuid.UuidCreator;
import java.util.UUID;

public record PlaneId(UUID id) {

    public static PlaneId of() {
        return new PlaneId(UuidCreator.getTimeOrdered());
    }

}

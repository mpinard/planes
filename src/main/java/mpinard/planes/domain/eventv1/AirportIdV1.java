package mpinard.planes.domain.eventv1;

import java.util.UUID;

public record AirportIdV1(UUID id) {

    public static AirportIdV1 of() {
        return new AirportIdV1(UUID.randomUUID());
    }

}

package mpinard.planes.domain.airport;

import java.util.UUID;

public record AirportId(UUID id) {

    public static AirportId of() {
        return new AirportId(UUID.randomUUID());
    }

}

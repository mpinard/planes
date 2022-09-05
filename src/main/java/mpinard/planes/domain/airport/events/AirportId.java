package mpinard.planes.domain.airport.events;

import java.util.UUID;

public record AirportId(UUID id) {

    public static AirportId of() {
        return new AirportId(UUID.randomUUID());
    }

}

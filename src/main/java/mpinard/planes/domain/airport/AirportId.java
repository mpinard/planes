package mpinard.planes.domain.airport;

import com.github.f4b6a3.uuid.UuidCreator;
import java.util.UUID;

public record AirportId(UUID id) {

    public static AirportId of() {
        return new AirportId(UuidCreator.getTimeOrdered());
    }

}

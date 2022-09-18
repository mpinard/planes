package mpinard.planes.domain.airport;

import lombok.AccessLevel;
import lombok.Value;
import lombok.With;
import mpinard.planes.domain.common.Coordinates;

@Value(staticConstructor = "of")
public class Airport {
    AirportId airportId;
    String name;
    String country;
    String continent;
    AirportClass airportClass;
    int population;
    Coordinates coordinates;
    @With(value = AccessLevel.PRIVATE)
    boolean open;

    public Airport purchase() {
        return this.withOpen(true);
    }

    public Airport close() {
        return this.withOpen(false);
    }
}

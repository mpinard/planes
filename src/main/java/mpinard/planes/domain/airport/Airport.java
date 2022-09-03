package mpinard.planes.domain.airport;

import lombok.AccessLevel;
import lombok.Value;
import lombok.With;
import mpinard.planes.domain.common.Coordinates;

@Value(staticConstructor = "of")
public class Airport {
    private String name;
    private String country;
    private String continent;
    private AirportClass airportClass;
    private int population;
    private Coordinates coordinates;
    @With(value = AccessLevel.PRIVATE)
    private boolean open;

    public Airport purchase() {
        return this.withOpen(true);
    }

    public Airport close() {
        return this.withOpen(false);
    }
}

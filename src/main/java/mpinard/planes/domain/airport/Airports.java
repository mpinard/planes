package mpinard.planes.domain.airport;

import lombok.experimental.UtilityClass;
import mpinard.planes.domain.common.Coordinates;

@UtilityClass
public class Airports {

    public static final Airport BARCELONA = Airport.of(
        "Barcelona", "Spain", "Europe", AirportClass.TWO, 1_620_343, Coordinates.of(5740, 3808), false);
    public static final Airport BERLIN = Airport.of("Berlin", "Germany", "Europe", AirportClass.TWO, 3_769_495, Coordinates.of(6112, 3324), true);
    public static final Airport BRUSSELS = Airport.of("Brussels", "Belgium", "Europe", AirportClass.ONE, 1_222_637, Coordinates.of(5816, 3412), true);
    public static final Airport MUNICH = Airport.of("Munich", "Germany", "Europe", AirportClass.ONE, 1_488_222, Coordinates.of(6028, 3512), true);
}

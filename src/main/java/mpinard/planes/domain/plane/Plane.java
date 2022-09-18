package mpinard.planes.domain.plane;

import lombok.Value;
import mpinard.planes.domain.airport.AirportId;

import java.math.BigDecimal;

@Value(staticConstructor = "of")
public class Plane {
    public static final int INITIAL_LEVEL = 1;

    PlaneId id;
    String callSign;
    AirportId destination;
    PlaneStatus status;
    PlaneType type;
    int speed;
    int range;
    BigDecimal weight;
    int speedLevel;
    int rangeLevel;
    int weightLevel;

    public static Plane create(PlaneId id, String callSign, AirportId airportId, PlaneType planeType) {
        return Plane.of(
            id,
            callSign,
            airportId,
            PlaneStatus.IDLE,
            planeType,
            planeType.getBaseSpeed(),
            planeType.getBaseRange(),
            planeType.getBaseWeight(),
            INITIAL_LEVEL,
            INITIAL_LEVEL,
            INITIAL_LEVEL);
    }
}

package mpinard.planes.domain.plane;

import lombok.Value;
import mpinard.planes.domain.airport.AirportClass;

import java.math.BigDecimal;

@Value(staticConstructor = "of")
public class PlaneType {
    PlaneTypeId id;
    String description;
    int passengers;
    int cargo;
    int baseSpeed;
    int baseRange;
    BigDecimal baseWeight;
    AirportClass size;
    int level;
    int unitCost;
}

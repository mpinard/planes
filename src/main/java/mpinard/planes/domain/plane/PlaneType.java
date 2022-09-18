package mpinard.planes.domain.plane;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class PlaneType {
    PlaneTypeId id;
    String description;
    int passengers;
    int cargo;
    int baseRange;
    int baseSpeed;
    BigDecimal baseWeight;
}

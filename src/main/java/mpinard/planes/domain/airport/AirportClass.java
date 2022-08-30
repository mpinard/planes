package mpinard.planes.domain.airport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(makeFinal = true)
public enum AirportClass {
    REGIONAL(1),
    MUNICIPAL(2),
    INTERNATIONAL(3);

    private int level;
}

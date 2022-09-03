package mpinard.planes.domain.airport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(makeFinal = true)
public enum AirportClass {
    ONE(1),
    TWO(2),
    THREE(3);

    private int level;
}

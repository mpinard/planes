package mpinard.planes.domain.common;

import lombok.Value;

@Value(staticConstructor = "of")
public class Coordinates {
    private int latitude;
    private int longitude;
}

package mpinard.planes.domain.common;

import lombok.Value;

@Value(staticConstructor = "of")
public class Coordinates {
    int latitude;
    int longitude;
}

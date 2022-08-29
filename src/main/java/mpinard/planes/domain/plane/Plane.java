package mpinard.planes.domain.plane;

import lombok.Value;

@Value(staticConstructor = "of")
public class Plane {
    private PlaneId id;
    private String callsign;
    private String destination;
    private String aircraft;
    private String eta;

}

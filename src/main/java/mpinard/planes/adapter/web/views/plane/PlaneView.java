package mpinard.planes.adapter.web.views.plane;

import lombok.Value;

@Value(staticConstructor = "of")
public class PlaneView {
    String callsign;
    String destination;
    String aircraft;
    String eta;
}

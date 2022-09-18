package mpinard.planes.adapter.web.views.plane;

import lombok.Value;

@Value(staticConstructor = "of")
public class PlaneModel {
    String callsign;
    String destination;
    String aircraft;
    String eta;
}

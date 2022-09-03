package mpinard.planes.adapter.web.views;

import lombok.Value;

@Value(staticConstructor = "of")
public class PlaneView {
    private String callsign;
    private String destination;
    private String aircraft;
    private String eta;
}

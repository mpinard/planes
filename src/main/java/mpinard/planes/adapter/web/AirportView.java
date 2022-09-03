package mpinard.planes.adapter.web;

import lombok.Value;

@Value(staticConstructor = "of")
public class AirportView {
    private String name;
    private String country;
    private String continent;
    private String airportClass;
    private String population;
}

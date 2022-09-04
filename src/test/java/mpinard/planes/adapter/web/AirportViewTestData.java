package mpinard.planes.adapter.web;

import mpinard.planes.adapter.web.views.AirportView;

public class AirportViewTestData {

    public static final AirportView BARCELONA = AirportView.builder()
        .name("Barcelona")
        .country("Spain")
        .continent("Europe")
        .airportClass("2")
        .population("1,620,343")
        .build();
    public static final AirportView BERLIN = AirportView.builder()
        .name("Berlin")
        .country("Germany")
        .continent("Europe")
        .airportClass("2")
        .population("3,769,495")
        .open(true)
        .build();
    public static final AirportView BRUSSELS = AirportView.builder()
        .name("Brussels")
        .country("Belgium")
        .continent("Europe")
        .airportClass("1")
        .population("1,222,637")
        .open(true)
        .build();
    public static final AirportView MUNICH = AirportView.builder()
        .name("Munich")
        .country("Germany")
        .continent("Europe")
        .airportClass("1")
        .population("1,488,222")
        .open(true)
        .build();

}

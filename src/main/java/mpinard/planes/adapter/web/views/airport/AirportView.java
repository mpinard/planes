package mpinard.planes.adapter.web.views.airport;

import lombok.Builder;
import lombok.Value;
import mpinard.planes.domain.airport.Airport;

import static mpinard.planes.adapter.web.formatters.FormatNumbers.formatWithCommas;

@Value
@Builder
public class AirportView {
    String name;
    String country;
    String continent;
    String airportClass;
    String population;
    boolean open;

    public static AirportView of(Airport airport) {
        return AirportView.builder()
            .name(airport.getName())
            .country(airport.getCountry())
            .continent(airport.getContinent())
            .airportClass(airport.getAirportClass().toString())
            .population(formatWithCommas(airport.getPopulation()))
            .open(airport.isOpen())
            .build();
    }
}

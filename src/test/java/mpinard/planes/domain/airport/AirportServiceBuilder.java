package mpinard.planes.domain.airport;

import lombok.Getter;

import java.util.List;

@Getter
public class AirportServiceBuilder {

    private final AirportRepository airportRepository = FakeAirportRepository.of();
    private final AirportService airportService = AirportService.of(airportRepository);

    public AirportService build() {
        airportRepository.saveAll(List.of(Airports.BARCELONA, Airports.BERLIN, Airports.BRUSSELS, Airports.MUNICH));
        return airportService;
    }

}

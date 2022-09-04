package mpinard.planes.domain.airport;

import lombok.Getter;

@Getter
public class AirportServiceBuilder {

    private final AirportRepository airportRepository = new FakeAirportRepository();
    private final AirportService airportService = new AirportService(airportRepository);

    public AirportService build() {
        return airportService;
    }

}

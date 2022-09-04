package mpinard.planes.domain.airport;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@FieldDefaults(makeFinal = true)
public class AirportService {

    private AirportRepository airportRepository;

    public List<Airport> allAirports() {
        return airportRepository.findAll();
    }

    public List<Airport> openAirports() {
        return airportRepository.findAllOpen();
    }

}

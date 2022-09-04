package mpinard.planes.domain.airport;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor(staticName = "of")
@FieldDefaults(makeFinal = true)
public class AirportService {

    private AirportRepository airportRepository;

    public List<Airport> all() {
        return airportRepository.findAll();
    }

    public List<Airport> open() {
        return airportRepository.findAllOpen();
    }

}

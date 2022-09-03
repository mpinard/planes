package mpinard.planes.domain.airport;

import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import static mpinard.planes.domain.airport.Airports.BARCELONA;
import static mpinard.planes.domain.airport.Airports.BERLIN;
import static mpinard.planes.domain.airport.Airports.BRUSSELS;
import static mpinard.planes.domain.airport.Airports.MUNICH;

@FieldDefaults(makeFinal = true)
public class AirportService {

    private CopyOnWriteArrayList<Airport> airports = new CopyOnWriteArrayList<>();

    public AirportService() {
        airports.addAll(List.of(BARCELONA, BERLIN, BRUSSELS, MUNICH));
    }

    public List<Airport> allAirports() {
        return List.copyOf(airports);
    }

    public List<Airport> openAirports() {
        return airports.stream()
            .filter(Airport::isOpen)
            .collect(Collectors.toUnmodifiableList());
    }

}

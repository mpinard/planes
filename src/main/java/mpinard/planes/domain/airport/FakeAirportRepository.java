package mpinard.planes.domain.airport;

import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static mpinard.planes.domain.airport.Airports.BARCELONA;
import static mpinard.planes.domain.airport.Airports.BERLIN;
import static mpinard.planes.domain.airport.Airports.BRUSSELS;
import static mpinard.planes.domain.airport.Airports.MUNICH;

@FieldDefaults(makeFinal = true)
public class FakeAirportRepository implements AirportRepository {

    private CopyOnWriteArrayList<Airport> airports = new CopyOnWriteArrayList<>();

    public FakeAirportRepository() {
        airports.addAll(List.of(BARCELONA, BERLIN, BRUSSELS, MUNICH));
    }

    @Override
    public List<Airport> findAll() {
        return List.copyOf(airports);
    }

    @Override
    public List<Airport> findAllOpen() {
        return airports.stream()
            .filter(Airport::isOpen).toList();
    }
}

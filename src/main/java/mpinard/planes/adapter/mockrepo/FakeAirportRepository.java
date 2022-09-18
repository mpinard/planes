package mpinard.planes.adapter.mockrepo;

import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import mpinard.planes.domain.airport.Airport;
import mpinard.planes.domain.airport.AirportRepository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.StreamSupport;

@FieldDefaults(makeFinal = true)
@NoArgsConstructor(staticName = "of")
public class FakeAirportRepository implements AirportRepository {

    private CopyOnWriteArrayList<Airport> airports = new CopyOnWriteArrayList<>();

    @Override
    public List<Airport> findAll() {
        return List.copyOf(airports);
    }

    @Override
    public List<Airport> findAllOpen() {
        return airports.stream()
            .filter(Airport::isOpen).toList();
    }

    @Override
    public List<Airport> saveAll(Iterable<Airport> toBeSaved) {
        airports.addAll(StreamSupport.stream(toBeSaved.spliterator(), false).toList());
        return List.copyOf(airports);
    }
}

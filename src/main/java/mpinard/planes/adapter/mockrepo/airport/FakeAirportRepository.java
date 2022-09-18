package mpinard.planes.adapter.mockrepo.airport;

import lombok.NoArgsConstructor;
import mpinard.planes.adapter.mockrepo.common.FakeRepository;
import mpinard.planes.domain.airport.Airport;
import mpinard.planes.domain.airport.AirportRepository;

import java.util.List;

@NoArgsConstructor(staticName = "of")
public class FakeAirportRepository extends FakeRepository<Airport> implements AirportRepository {

    @Override
    public List<Airport> findAllOpen() {
        return findAll().stream().filter(Airport::isOpen).toList();
    }

}

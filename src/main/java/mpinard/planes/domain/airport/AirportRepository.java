package mpinard.planes.domain.airport;

import java.util.List;

public interface AirportRepository {

    List<Airport> findAll();

    List<Airport> findAllOpen();

}

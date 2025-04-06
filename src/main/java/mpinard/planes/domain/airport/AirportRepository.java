package mpinard.planes.domain.airport;

import java.util.List;

import mpinard.planes.domain.common.Repository;

public interface AirportRepository extends Repository<Airport> {

    List<Airport> findAllOpen();

}

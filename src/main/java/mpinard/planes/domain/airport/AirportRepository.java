package mpinard.planes.domain.airport;

import mpinard.planes.domain.common.Repository;

import java.util.List;

public interface AirportRepository extends Repository<Airport> {

    List<Airport> findAllOpen();

}

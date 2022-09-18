package mpinard.planes.domain.plane;

import java.util.List;

public interface PlaneTypeRepository {

    List<PlaneType> findAll();

    List<PlaneType> saveAll(Iterable<PlaneType> planeTypes);

}

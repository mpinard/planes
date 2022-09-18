package mpinard.planes.domain.plane;

import java.util.List;

public interface PlaneRepository {

    List<Plane> findAll();

    List<Plane> saveAll(Iterable<Plane> planeTypes);

}

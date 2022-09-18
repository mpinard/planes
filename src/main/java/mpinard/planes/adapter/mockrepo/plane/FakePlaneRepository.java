package mpinard.planes.adapter.mockrepo.plane;

import lombok.NoArgsConstructor;
import mpinard.planes.adapter.mockrepo.common.FakeRepository;
import mpinard.planes.domain.plane.Plane;
import mpinard.planes.domain.plane.PlaneRepository;

@NoArgsConstructor(staticName = "of")
public class FakePlaneRepository extends FakeRepository<Plane> implements PlaneRepository {

}

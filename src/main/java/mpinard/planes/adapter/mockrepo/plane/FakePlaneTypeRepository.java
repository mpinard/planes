package mpinard.planes.adapter.mockrepo.plane;

import lombok.NoArgsConstructor;
import mpinard.planes.adapter.mockrepo.common.FakeRepository;
import mpinard.planes.domain.plane.PlaneType;
import mpinard.planes.domain.plane.PlaneTypeRepository;

@NoArgsConstructor(staticName = "of")
public class FakePlaneTypeRepository extends FakeRepository<PlaneType> implements PlaneTypeRepository {

}

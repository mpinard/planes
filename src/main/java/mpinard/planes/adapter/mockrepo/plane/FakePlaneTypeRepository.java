package mpinard.planes.adapter.mockrepo.plane;

import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import mpinard.planes.domain.plane.PlaneType;
import mpinard.planes.domain.plane.PlaneTypeRepository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.StreamSupport;

@FieldDefaults(makeFinal = true)
@NoArgsConstructor(staticName = "of")
public class FakePlaneTypeRepository implements PlaneTypeRepository {

    private CopyOnWriteArrayList<PlaneType> planeTypes = new CopyOnWriteArrayList<>();

    @Override
    public List<PlaneType> findAll() {
        return List.copyOf(planeTypes);
    }

    @Override
    public List<PlaneType> saveAll(Iterable<PlaneType> toBeSaved) {
        planeTypes.addAll(StreamSupport.stream(toBeSaved.spliterator(), false).toList());
        return List.copyOf(planeTypes);
    }
}

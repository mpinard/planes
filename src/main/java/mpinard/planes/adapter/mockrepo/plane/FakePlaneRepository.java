package mpinard.planes.adapter.mockrepo.plane;

import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import mpinard.planes.domain.plane.Plane;
import mpinard.planes.domain.plane.PlaneRepository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.StreamSupport;

@FieldDefaults(makeFinal = true)
@NoArgsConstructor(staticName = "of")
public class FakePlaneRepository implements PlaneRepository {

    private CopyOnWriteArrayList<Plane> planes = new CopyOnWriteArrayList<>();

    @Override
    public List<Plane> findAll() {
        return List.copyOf(planes);
    }

    @Override
    public List<Plane> saveAll(Iterable<Plane> toBeSaved) {
        planes.addAll(StreamSupport.stream(toBeSaved.spliterator(), false).toList());
        return List.copyOf(planes);
    }
}

package mpinard.planes.adapter.domain.plane;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@AllArgsConstructor
@FieldDefaults(makeFinal = true)
public class PlaneService {

    private CopyOnWriteArrayList<Plane> planes = new CopyOnWriteArrayList<>();

    public List<Plane> addPlane(Plane plane) {
        planes.add(plane);
        return List.copyOf(planes);
    }
}

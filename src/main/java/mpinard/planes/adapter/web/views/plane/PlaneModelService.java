package mpinard.planes.adapter.web.views.plane;

import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@NoArgsConstructor
@FieldDefaults(makeFinal = true)
public class PlaneModelService {

    private CopyOnWriteArrayList<PlaneModel> planeModels = new CopyOnWriteArrayList<>();

    public List<PlaneModel> addPlane(PlaneModel planeModel) {
        planeModels.add(planeModel);
        return List.copyOf(planeModels);
    }
}

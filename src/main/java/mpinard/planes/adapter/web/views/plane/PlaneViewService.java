package mpinard.planes.adapter.web.views.plane;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true)
public class PlaneViewService {
    
    public List<PlaneView> all() {
        return List.of(
            PlaneView.of("P2C02", "TEHRAN", "CYCLONE-P", "BOARDING"),
            PlaneView.of("C2C03", "DELHI", "CYCLONE-P", "LANDED"),
            PlaneView.of("P2C01", "TEHRAN", "CYCLONE-P", "LANDED"));
    }

}

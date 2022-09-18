package mpinard.planes.adapter.web.airport;

import mpinard.planes.adapter.web.views.plane.PlaneModel;
import mpinard.planes.adapter.web.views.plane.PlaneModelService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlaneModelServiceTest {

    private static final PlaneModel BEARCLAW = PlaneModel.of("PL0001", "MUNICH", "BEARCLAW-P", "IDLE");
    private static final PlaneModel GRIFFON = PlaneModel.of("PL0002", "BRUSSELS", "GRIFFON-C", "IDLE");

    private final PlaneModelService planeModelService = new PlaneModelService();

    @Test
    public void When_AddSinglePlane_Expect_ResultsInNewPlaneOnly() {
        assertThat(planeModelService.addPlane(BEARCLAW)).containsExactly(BEARCLAW);
    }

    @Test
    public void When_AddMultiplePlanes_Expect_ResultsInMultiplePlanes() {
        assertThat(planeModelService.addPlane(BEARCLAW)).containsExactly(BEARCLAW);
        assertThat(planeModelService.addPlane(GRIFFON)).containsExactly(BEARCLAW, GRIFFON);
    }

}
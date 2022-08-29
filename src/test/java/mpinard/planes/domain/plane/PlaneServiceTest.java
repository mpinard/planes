package mpinard.planes.domain.plane;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlaneServiceTest {

    private static final Plane BEARCLAW = Plane.of(PlaneId.of(), "PL0001", "MUNICH", "BEARCLAW-P", "IDLE");
    private static final Plane GRIFFON = Plane.of(PlaneId.of(), "PL0002", "BRUSSELS", "GRIFFON-C", "IDLE");

    private final PlaneService planeService = new PlaneService();

    @Test
    public void When_AddSinglePlane_Expect_ResultsInNewPlaneOnly() {
        assertThat(planeService.addPlane(BEARCLAW)).containsExactly(BEARCLAW);
    }

    @Test
    public void When_AddMultiplePlanes_Expect_ResultsInMultiplePlanes() {
        assertThat(planeService.addPlane(BEARCLAW)).containsExactly(BEARCLAW);
        assertThat(planeService.addPlane(GRIFFON)).containsExactly(BEARCLAW, GRIFFON);
    }

}
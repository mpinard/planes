package mpinard.planes.domain.plane;

import mpinard.planes.domain.airport.Airports;
import org.junit.jupiter.api.Test;

import static mpinard.planes.domain.plane.Plane.INITIAL_LEVEL;
import static org.assertj.core.api.Assertions.assertThat;

public class PlaneTest {

    @Test
    public void When_Create_Expect_CreatedWithDefaults() {
        assertThat(Plane.create(Planes.BEARCLAW_P.getId(), Planes.BEARCLAW_P.getCallSign(), Airports.BERLIN.getId(), PlaneTypes.BEARCLAW_P))
            .isEqualTo(
                Plane.of(
                    Planes.BEARCLAW_P.getId(),
                    Planes.BEARCLAW_P.getCallSign(),
                    Airports.BERLIN.getId(),
                    PlaneStatus.IDLE,
                    PlaneTypes.BEARCLAW_P,
                    PlaneTypes.BEARCLAW_P.getBaseSpeed(),
                    PlaneTypes.BEARCLAW_P.getBaseRange(),
                    PlaneTypes.BEARCLAW_P.getBaseWeight(),
                    INITIAL_LEVEL,
                    INITIAL_LEVEL,
                    INITIAL_LEVEL));
    }

}
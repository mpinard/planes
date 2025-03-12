package mpinard.planes.adapter.web.views.airport;

import mpinard.planes.domain.airport.Airports;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AirportViewTest {

    @Test
    public void When_CreateFromBarcelona_Expect_BarcelonaView() {
        assertThat(AirportView.of(Airports.BARCELONA)).isEqualTo(AirportViewTestData.BARCELONA);
    }

}
package mpinard.planes.adapter.web.views.airport;

import static mpinard.planes.adapter.web.views.airport.AirportViewTestData.BARCELONA;
import static mpinard.planes.adapter.web.views.airport.AirportViewTestData.BERLIN;
import static mpinard.planes.adapter.web.views.airport.AirportViewTestData.BRUSSELS;
import static mpinard.planes.adapter.web.views.airport.AirportViewTestData.MUNICH;
import static org.assertj.core.api.Assertions.assertThat;

import lombok.experimental.FieldDefaults;
import mpinard.planes.domain.airport.AirportService;
import mpinard.planes.domain.airport.AirportServiceBuilder;
import org.junit.jupiter.api.Test;

@FieldDefaults(makeFinal = true)
public class AirportViewServiceTest {

    private AirportService airportService = new AirportServiceBuilder().build();
    private AirportViewService airportViewService = new AirportViewService(airportService);

    @Test
    public void When_All_Expect_AllAirports() {
        assertThat(airportViewService.all()).containsExactly(BARCELONA, BERLIN, BRUSSELS, MUNICH);
    }

    @Test
    public void When_Open_Expect_OpenAirports() {
        assertThat(airportViewService.open()).containsExactly(BERLIN, BRUSSELS, MUNICH);
    }


}
package mpinard.planes.adapter.web;

import lombok.experimental.FieldDefaults;
import mpinard.planes.adapter.web.views.AirportViewService;
import mpinard.planes.domain.airport.AirportService;
import org.junit.jupiter.api.Test;

import static mpinard.planes.adapter.web.AirportViewTestData.BARCELONA;
import static mpinard.planes.adapter.web.AirportViewTestData.BERLIN;
import static mpinard.planes.adapter.web.AirportViewTestData.BRUSSELS;
import static mpinard.planes.adapter.web.AirportViewTestData.MUNICH;
import static org.assertj.core.api.Assertions.assertThat;

@FieldDefaults(makeFinal = true)
public class AirportViewServiceTest {

    private AirportService airportService = new AirportService();
    private AirportViewService airportViewService = new AirportViewService(airportService);

    @Test
    public void When_AllAirports_Expect_AllAirports() {
        assertThat(airportViewService.allAirports()).containsExactly(BARCELONA, BERLIN, BRUSSELS, MUNICH);
    }

    @Test
    public void When_OpenAirports_Expect_OpenAirports() {
        assertThat(airportViewService.openAirports()).containsExactly(BERLIN, BRUSSELS, MUNICH);
    }


}
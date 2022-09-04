package mpinard.planes.domain.airport;

import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@FieldDefaults(makeFinal = true)
public class AirportServiceTest {

    private AirportService airportService = new AirportServiceBuilder().build();

    @Test
    public void When_All_Expect_AllAirports() {
        assertThat(airportService.all()).containsExactly(Airports.BARCELONA, Airports.BERLIN, Airports.BRUSSELS, Airports.MUNICH);
    }

    @Test
    public void When_Open_Expect_OpenAirports() {
        assertThat(airportService.open()).containsExactly(Airports.BERLIN, Airports.BRUSSELS, Airports.MUNICH);
    }

}
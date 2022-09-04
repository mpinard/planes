package mpinard.planes.domain.airport;

import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@FieldDefaults(makeFinal = true)
public class AirportServiceTest {
    private AirportService airportService = new AirportServiceBuilder().build();

    @Test
    public void When_InitialState_AllAirports_Expect_AllAirports() {
        assertThat(airportService.allAirports()).containsExactly(Airports.BARCELONA, Airports.BERLIN, Airports.BRUSSELS, Airports.MUNICH);
    }

    @Test
    public void When_InitialState_OpenAirports_Expect_OpenAirports() {
        assertThat(airportService.openAirports()).containsExactly(Airports.BERLIN, Airports.BRUSSELS, Airports.MUNICH);
    }

}
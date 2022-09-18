package mpinard.planes.domain.airport;

import mpinard.planes.domain.common.Coordinates;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AirportTest {

    private static final Airport BERLIN_AIRPORT = Airport.of(
        AirportId.of(),
        "Berlin",
        "Germany",
        "Europe",
        AirportClass.TWO,
        3_769_495,
        Coordinates.of(6112, 3324),
        false);

    @Test
    public void When_AirportCreated_Expect_Created() {
        assertBerlinValues(BERLIN_AIRPORT, false);
    }

    @Test
    public void When_AirportPurchased_Expect_OpenIsTrue() {
        assertBerlinValues(BERLIN_AIRPORT.purchase(), true);
    }

    @Test
    public void When_AirportClosed_Expect_OpenIsFalse() {
        assertBerlinValues(BERLIN_AIRPORT.purchase().close(), false);
    }

    private void assertBerlinValues(Airport airport, boolean expectedIsOpen) {
        assertThat(airport.getName()).isEqualTo("Berlin");
        assertThat(airport.getCountry()).isEqualTo("Germany");
        assertThat(airport.getContinent()).isEqualTo("Europe");
        assertThat(airport.getAirportClass()).isEqualTo(AirportClass.TWO);
        assertThat(airport.getPopulation()).isEqualTo(3_769_495);
        assertThat(airport.getCoordinates()).isEqualTo(Coordinates.of(6112, 3324));
        assertThat(airport.isOpen()).isEqualTo(expectedIsOpen);

    }

}
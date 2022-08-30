package mpinard.planes.domain.airport;

import mpinard.planes.domain.common.Coordinates;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AirportTest {

    private static final Airport TEHRAN_AIRPORT = Airport.of(
        "TEHRAN",
        AirportClass.INTERNATIONAL,
        10_000_000,
        Coordinates.of(7188, 3988),
        false);

    @Test
    public void When_AirportCreated_Expect_Created() {
        assertTehranValues(TEHRAN_AIRPORT, false);
    }

    @Test
    public void When_AirportPurchased_Expect_OpenIsTrue() {
        assertTehranValues(TEHRAN_AIRPORT.purchase(), true);
    }

    @Test
    public void When_AirportClosed_Expect_OpenIsFalse() {
        assertTehranValues(TEHRAN_AIRPORT.purchase().close(), false);
    }

    private void assertTehranValues(Airport airport, boolean expectedIsOpen) {
        assertThat(airport.getName()).isEqualTo("TEHRAN");
        assertThat(airport.getAirportClass()).isEqualTo(AirportClass.INTERNATIONAL);
        assertThat(airport.getPopulation()).isEqualTo(10_000_000);
        assertThat(airport.getCoordinates()).isEqualTo(Coordinates.of(7188, 3988));
        assertThat(airport.isOpen()).isEqualTo(expectedIsOpen);

    }

}
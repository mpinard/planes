package mpinard.planes.adapter.jpa.airport;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import mpinard.planes.domain.airport.AirportClass;

class AirportEntityTest {

    @Test
    void When_Create_Expect_Created() {
        AirportEntity airport = AirportEntity.builder()
            .name("Berlin Airport")
            .country("Germany")
            .continent("Europe")
            .airportClass(AirportClass.TWO)
            .population(3769495)
            .latitude(new BigDecimal("52.5200")) 
            .longitude(new BigDecimal("13.4050"))
            .open(true)
            .build();

        assertThat(airport.getId()).isNotNull();
        assertThat(airport.getName()).isEqualTo("Berlin Airport");
        assertThat(airport.getCountry()).isEqualTo("Germany");
        assertThat(airport.getContinent()).isEqualTo("Europe");
        assertThat(airport.getAirportClass()).isEqualTo(AirportClass.TWO);
        assertThat(airport.getPopulation()).isEqualTo(3769495);
        assertThat(airport.getLatitude()).isEqualTo(new BigDecimal("52.5200"));
        assertThat(airport.getLongitude()).isEqualTo(new BigDecimal("13.4050"));
        assertThat(airport.isOpen()).isTrue();
    }
}
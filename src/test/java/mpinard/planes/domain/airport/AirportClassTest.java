package mpinard.planes.domain.airport;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AirportClassTest {

    @Test
    public void When_ToString_Expect_StringValue() {
        assertThat(AirportClass.ONE.toString()).isEqualTo("1");
        assertThat(AirportClass.TWO.toString()).isEqualTo("2");
        assertThat(AirportClass.THREE.toString()).isEqualTo("3");
    }

}
package mpinard.planes.domain.airport;

import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@FieldDefaults(makeFinal = true)
public class FakeAirportRepositoryTest {

    private FakeAirportRepository fakeAirportRepository = new FakeAirportRepository();

    @Test
    public void When_InitialState_FindAll_Expect_AllAirports() {
        assertThat(fakeAirportRepository.findAll()).containsExactly(Airports.BARCELONA, Airports.BERLIN, Airports.BRUSSELS, Airports.MUNICH);
    }

    @Test
    public void When_Update_AllAirportsResult_Expect_Exception() {
        assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(() -> fakeAirportRepository.findAll().add(Airports.BERLIN));
    }

    @Test
    public void When_InitialState_OpenAirports_Expect_OpenAirports() {
        assertThat(fakeAirportRepository.findAllOpen()).containsExactly(Airports.BERLIN, Airports.BRUSSELS, Airports.MUNICH);
    }

    @Test
    public void When_Update_OpenAirportsResult_Expect_Exception() {
        assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(() -> fakeAirportRepository.findAllOpen().add(Airports.BERLIN));
    }

}
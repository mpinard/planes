package mpinard.planes.domain.airport;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class FakeAirportRepositoryTest {

    private final FakeAirportRepository fakeAirportRepository = FakeAirportRepository.of();

    @Test
    public void Whsen_FindAll_EmptyRepository_Expect_EmptyResult() {
        assertThat(fakeAirportRepository.findAll()).isEmpty();
    }

    @Test
    public void When_FindAll_DefaultAirports_Expect_AllAirports() {
        saveDefaultAirports();
        assertThat(fakeAirportRepository.findAll()).containsExactly(Airports.BARCELONA, Airports.BERLIN, Airports.BRUSSELS, Airports.MUNICH);
    }

    @Test
    public void When_UpdateFindAllResult_Expect_Exception() {
        assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(() -> fakeAirportRepository.findAll().add(Airports.BERLIN));
    }

    @Test
    public void When_FindAllOpen_EmptyRepository_Expect_EmptyResult() {
        assertThat(fakeAirportRepository.findAllOpen()).isEmpty();
    }

    @Test
    public void When_FindAllOpen_DefaultAirports_Expect_OpenAirports() {
        saveDefaultAirports();
        assertThat(fakeAirportRepository.findAllOpen()).containsExactly(Airports.BERLIN, Airports.BRUSSELS, Airports.MUNICH);
    }

    @Test
    public void When_UpdateFindAllOpenResult_Expect_Exception() {
        assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(() -> fakeAirportRepository.findAllOpen().add(Airports.BERLIN));
    }

    @Test
    public void When_SaveAll_Expect_AllAirportArgumentsSaved() {
        assertThat(fakeAirportRepository.findAll()).isEmpty();
        assertThat(fakeAirportRepository.saveAll(List.of(Airports.BARCELONA, Airports.BERLIN, Airports.BRUSSELS, Airports.MUNICH)))
            .containsExactly(Airports.BARCELONA, Airports.BERLIN, Airports.BRUSSELS, Airports.MUNICH);
        assertThat(fakeAirportRepository.findAll())
            .containsExactly(Airports.BARCELONA, Airports.BERLIN, Airports.BRUSSELS, Airports.MUNICH);
    }

    private void saveDefaultAirports() {
        fakeAirportRepository.saveAll(List.of(Airports.BARCELONA, Airports.BERLIN, Airports.BRUSSELS, Airports.MUNICH));
    }


}
package mpinard.planes.adapter.mockrepo.airport;

import mpinard.planes.domain.airport.Airports;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class FakeAirportRepositoryTest {

    private final FakeAirportRepository airportRepository = FakeAirportRepository.of();

    @Test
    public void Whsen_FindAll_EmptyRepository_Expect_EmptyResult() {
        assertThat(airportRepository.findAll()).isEmpty();
    }

    @Test
    public void When_FindAll_DefaultAirports_Expect_AllAirports() {
        saveDefaultAirports();
        assertThat(airportRepository.findAll()).containsExactly(Airports.BARCELONA, Airports.BERLIN, Airports.BRUSSELS, Airports.MUNICH);
    }

    @Test
    public void When_UpdateFindAllResult_Expect_Exception() {
        assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(() -> airportRepository.findAll().add(Airports.BERLIN));
    }

    @Test
    public void When_FindAllOpen_EmptyRepository_Expect_EmptyResult() {
        assertThat(airportRepository.findAllOpen()).isEmpty();
    }

    @Test
    public void When_FindAllOpen_DefaultAirports_Expect_OpenAirports() {
        saveDefaultAirports();
        assertThat(airportRepository.findAllOpen()).containsExactly(Airports.BERLIN, Airports.BRUSSELS, Airports.MUNICH);
    }

    @Test
    public void When_UpdateFindAllOpenResult_Expect_Exception() {
        assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(() -> airportRepository.findAllOpen().add(Airports.BERLIN));
    }

    @Test
    public void When_SaveAll_Expect_AllAirportArgumentsSaved() {
        assertThat(airportRepository.findAll()).isEmpty();
        assertThat(airportRepository.saveAll(List.of(Airports.BARCELONA, Airports.BERLIN, Airports.BRUSSELS, Airports.MUNICH)))
            .containsExactly(Airports.BARCELONA, Airports.BERLIN, Airports.BRUSSELS, Airports.MUNICH);
        assertThat(airportRepository.findAll())
            .containsExactly(Airports.BARCELONA, Airports.BERLIN, Airports.BRUSSELS, Airports.MUNICH);
    }

    private void saveDefaultAirports() {
        airportRepository.saveAll(List.of(Airports.BARCELONA, Airports.BERLIN, Airports.BRUSSELS, Airports.MUNICH));
    }


}
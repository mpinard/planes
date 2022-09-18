package mpinard.planes.adapter.mockrepo.plane;

import mpinard.planes.domain.plane.Planes;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class FakePlaneRepositoryTest {

    private final FakePlaneRepository repository = FakePlaneRepository.of();

    @Test
    public void When_FindAll_EmptyRepository_Expect_EmptyResult() {
        assertThat(repository.findAll()).isEmpty();
    }

    @Test
    public void When_FindAll_StartingPlanes_Expect_StartingPlanes() {
        saveStartingPlanes();
        assertThat(repository.findAll()).containsExactlyElementsOf(Planes.STARTING_PLANES);
    }

    @Test
    public void When_UpdateFindAllResult_Expect_Exception() {
        assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(() -> repository.findAll().add(Planes.BEARCLAW_P));
    }

    @Test
    public void When_SaveAll_Expect_AllAirportArgumentsSaved() {
        assertThat(repository.findAll()).isEmpty();
        assertThat(repository.saveAll(Planes.STARTING_PLANES)).containsExactlyElementsOf(Planes.STARTING_PLANES);
        assertThat(repository.findAll()).containsExactlyElementsOf(Planes.STARTING_PLANES);
    }

    private void saveStartingPlanes() {
        repository.saveAll(Planes.STARTING_PLANES);
    }

}
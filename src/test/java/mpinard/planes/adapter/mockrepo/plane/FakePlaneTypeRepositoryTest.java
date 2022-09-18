package mpinard.planes.adapter.mockrepo.plane;

import mpinard.planes.domain.plane.PlaneTypeRepository;
import mpinard.planes.domain.plane.PlaneTypes;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class FakePlaneTypeRepositoryTest {

    private final PlaneTypeRepository planeTypeRepository = FakePlaneTypeRepository.of();

    @Test
    public void When_FindAll_EmptyRepository_Expect_EmptyResult() {
        assertThat(planeTypeRepository.findAll()).isEmpty();
    }

    @Test
    public void When_FindAll_DefaultPlaneTypes_Expect_AllPlaneTypes() {
        saveDefaultPlaneTypes();
        assertThat(planeTypeRepository.findAll()).containsExactlyElementsOf(PlaneTypes.ALL);
    }

    @Test
    public void When_UpdateFindAllResult_Expect_Exception() {
        assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(() -> planeTypeRepository.findAll().add(PlaneTypes.BEARCLAW_C));
    }

    @Test
    public void When_SaveAll_Expect_AllAirportArgumentsSaved() {
        assertThat(planeTypeRepository.findAll()).isEmpty();
        assertThat(planeTypeRepository.saveAll(PlaneTypes.ALL)).containsExactlyElementsOf(PlaneTypes.ALL);
        assertThat(planeTypeRepository.findAll()).containsExactlyElementsOf(PlaneTypes.ALL);
    }

    private void saveDefaultPlaneTypes() {
        planeTypeRepository.saveAll(PlaneTypes.ALL);
    }


}
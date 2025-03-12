package mpinard.planes.adapter.web.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import mpinard.planes.adapter.web.views.airport.AirportView;
import mpinard.planes.adapter.web.views.airport.AirportViewService;
import mpinard.planes.adapter.web.views.plane.PlaneView;
import mpinard.planes.adapter.web.views.plane.PlaneViewService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

@ExtendWith(MockitoExtension.class)
class PlanesControllerTest {

    @Mock
    private PlaneViewService planeViewService;

    @Mock
    private AirportViewService airportViewService;

    @Mock
    private Model model;

    @Mock
    private PlaneView planeView;

    @Mock
    private AirportView airportView;

    @InjectMocks
    private PlanesController planesController;

    @Test
    void When_ShowPlanes_Expect_Planes() {
        when(planeViewService.all()).thenReturn(List.of(planeView));

        assertThat(planesController.showPlanes(model)).isEqualTo("planes");

        verify(model).addAttribute("planes", List.of(planeView));
        verify(model).addAttribute("availablePlaneSlots", "1");
        verify(model).addAttribute("coins", "30,000");
        verify(model).addAttribute("level", "1");
    }

    @Test
    void When_ShowAirports_Open_Expect_OpenAirports() {
        when(airportViewService.open()).thenReturn(List.of(airportView));

        assertThat(planesController.showAirports(AirportViewService.OpenQuery.OPEN, model)).isEqualTo("airports");

        verify(model).addAttribute("airports", List.of(airportView));
        verify(model).addAttribute("open", true);
        verify(model).addAttribute("coins", "30,000");
        verify(model).addAttribute("level", "1");
    }

}
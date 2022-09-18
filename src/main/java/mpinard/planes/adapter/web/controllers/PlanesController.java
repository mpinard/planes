package mpinard.planes.adapter.web.controllers;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import mpinard.planes.adapter.web.views.airport.AirportViewService;
import mpinard.planes.adapter.web.views.plane.PlaneView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
@FieldDefaults(makeFinal = true)
public class PlanesController {

  private AirportViewService airportViewService;

  @GetMapping("/")
  public String showPlanes(Model model) {
    List<PlaneView> planes = List.of(
        PlaneView.of("P2C02", "TEHRAN", "CYCLONE-P", "BOARDING"),
        PlaneView.of("C2C03", "DELHI", "CYCLONE-P", "LANDED"),
        PlaneView.of("P2C01", "TEHRAN", "CYCLONE-P", "LANDED"));
    model.addAttribute("planes", planes);
    model.addAttribute("availablePlaneSlots", "1");

    model.addAttribute("coins", "30,000");
    model.addAttribute("level", "1");

    return "planes";
  }

  @GetMapping("/airports")
  public String showAirports(@RequestParam(name = "open", defaultValue = "OPEN") AirportViewService.OpenQuery open, Model model) {
    model.addAttribute("airports", open.apply(airportViewService));
    model.addAttribute("open", open == AirportViewService.OpenQuery.OPEN);

    model.addAttribute("coins", "30,000");
    model.addAttribute("level", "1");

    return "airports";
  }


}

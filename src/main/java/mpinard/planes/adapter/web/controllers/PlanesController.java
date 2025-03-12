package mpinard.planes.adapter.web.controllers;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import mpinard.planes.adapter.web.views.airport.AirportViewService;
import mpinard.planes.adapter.web.views.plane.PlaneViewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@FieldDefaults(makeFinal = true)
public class PlanesController {

  private PlaneViewService planeViewService;
  private AirportViewService airportViewService;

  @GetMapping("/")
  public String showPlanes(Model model) {
    model.addAttribute("planes", planeViewService.all());
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

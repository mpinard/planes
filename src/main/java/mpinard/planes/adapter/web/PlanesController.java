package mpinard.planes.adapter.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PlanesController {

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
  public String showAirports(Model model) {
    List<AirportView> airports = List.of(
        AirportView.of("Berlin", "Germany", "Europe", "2", "3,769,495"),
        AirportView.of("Brussels", "Belgium", "Europe", "1", "1,222,637"),
        AirportView.of("Munich", "Germany", "Europe", "1", "1,488,222"));
    model.addAttribute("airports", airports);

    model.addAttribute("coins", "30,000");
    model.addAttribute("level", "1");

    return "airports";
  }


}

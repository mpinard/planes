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
    model.addAttribute("availablePlaneSlots", "3");

    model.addAttribute("coins", "15,000");
    model.addAttribute("level", "1");

    return "planes";
  }

}

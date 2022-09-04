package mpinard.planes.adapter.web.views;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import mpinard.planes.domain.airport.AirportService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true)
public class AirportViewService {

    private AirportService airportService;

    public List<AirportView> allAirports() {
        return airportService.allAirports().stream().map(AirportView::of).collect(Collectors.toUnmodifiableList());
    }

    public List<AirportView> openAirports() {
        return airportService.openAirports().stream().map(AirportView::of).collect(Collectors.toUnmodifiableList());
    }

}

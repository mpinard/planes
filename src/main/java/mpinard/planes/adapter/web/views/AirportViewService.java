package mpinard.planes.adapter.web.views;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import mpinard.planes.domain.airport.Airport;
import mpinard.planes.domain.airport.AirportService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true)
public class AirportViewService {

    private AirportService airportService;

    public List<AirportView> all() {
        return OpenQuery.ALL.apply(airportService);
    }

    public List<AirportView> open() {
        return OpenQuery.OPEN.apply(airportService);
    }

    @AllArgsConstructor
    @FieldDefaults(makeFinal = true)
    public enum OpenQuery {
      ALL(AirportViewService::all, AirportService::all),
      OPEN(AirportViewService::open, AirportService::open);

      private Function<AirportViewService, List<AirportView>> viewQuery;
      private Function<AirportService, List<Airport>> serviceQuery;

      public List<AirportView> apply(AirportViewService airportViewService) {
        return viewQuery.apply(airportViewService);
      }

      private List<AirportView> apply(AirportService airportService) {
        return serviceQuery.apply(airportService).stream().map(AirportView::of).toList();
      }

    }
}

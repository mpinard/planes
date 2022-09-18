package mpinard.planes;

import mpinard.planes.domain.airport.AirportRepository;
import mpinard.planes.domain.airport.AirportService;
import mpinard.planes.domain.airport.Airports;
import mpinard.planes.adapter.mockrepo.FakeAirportRepository;
import mpinard.planes.domain.common.GameClock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public GameClock gameClock() {
        return GameClock.of();
    }

    @Bean
    public AirportRepository airportRepository() {
        FakeAirportRepository airportRepository = FakeAirportRepository.of();
        airportRepository.saveAll(List.of(Airports.BARCELONA, Airports.BERLIN, Airports.BRUSSELS, Airports.MUNICH));
        return airportRepository;
    }

    @Bean
    public AirportService airportService(AirportRepository airportRepository) {
        return AirportService.of(airportRepository);
    }

}

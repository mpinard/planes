package mpinard.planes;

import mpinard.planes.domain.airport.Airport;
import mpinard.planes.domain.airport.AirportRepository;
import mpinard.planes.domain.airport.AirportService;
import mpinard.planes.domain.airport.FakeAirportRepository;
import mpinard.planes.domain.common.GameClock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
        return new FakeAirportRepository();
    }

    @Bean
    public AirportService airportService(AirportRepository airportRepository) {
        return new AirportService(airportRepository);
    }

}

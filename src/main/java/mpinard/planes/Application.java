package mpinard.planes;

import mpinard.planes.domain.airport.AirportService;
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
    public GameClock getGameClock() {
        return GameClock.of();
    }

    @Bean
    public AirportService getAirportService() {
        return new AirportService();
    }

}

package mpinard.planes.adapter.jpa.airport;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mpinard.planes.domain.airport.AirportId;

@Entity
@Table(name = "airport")
@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Builder
public class AirportEntity {

    @EmbeddedId
    @Builder.Default
    private AirportId id = AirportId.of();

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String continent;

    @Column(name = "airport_class", nullable = false)
    private int airportClass;

    @Column(nullable = false)
    private int population;

    @Column(nullable = false)
    private BigDecimal latitude;

    @Column(nullable = false)
    private BigDecimal longitude;

    @Column(nullable = false)
    private boolean open;

    @Column(nullable = false)
    private Integer version;

}
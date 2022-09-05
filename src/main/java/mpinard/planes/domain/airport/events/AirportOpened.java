package mpinard.planes.domain.airport.events;

import lombok.Value;
import lombok.With;
import mpinard.planes.domain.event.DomainEvent;
import mpinard.planes.domain.event.DomainEventId;
import mpinard.planes.domain.event.DomainEventType;

@Value(staticConstructor = "of")
public class AirportOpened implements DomainEvent<AirportOpened> {
    private DomainEventId id;
    private AirportId airportId;
    @With
    private Long sequenceNumber;
    @With
    private boolean replay;

    public static AirportOpened of(AirportId airportId) {
        return AirportOpened.of(DomainEventId.of(), airportId, null, false);
    }

    @Override
    public DomainEventType getType() {
        return AirportEvent.AIRPORT_OPENED;
    }
}

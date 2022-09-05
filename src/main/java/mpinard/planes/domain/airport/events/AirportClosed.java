package mpinard.planes.domain.airport.events;

import lombok.Value;
import lombok.With;
import mpinard.planes.domain.event.DomainEvent;
import mpinard.planes.domain.event.DomainEventId;
import mpinard.planes.domain.event.DomainEventType;

@Value(staticConstructor = "of")
public class AirportClosed implements DomainEvent<AirportClosed> {
    private DomainEventId id;
    private AirportId airportId;
    @With
    private Long sequenceNumber;
    @With
    private boolean replay;

    public static AirportClosed of(AirportId airportId) {
        return AirportClosed.of(DomainEventId.of(), airportId, null, false);
    }

    @Override
    public DomainEventType getType() {
        return AirportEvent.AIRPORT_CLOSED;
    }
}

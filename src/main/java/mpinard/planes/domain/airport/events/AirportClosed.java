package mpinard.planes.domain.airport.events;

import lombok.Value;
import lombok.With;
import mpinard.planes.domain.event.DomainEvent;
import mpinard.planes.domain.event.EventId;
import mpinard.planes.domain.event.EventType;

import java.time.OffsetDateTime;

@Value(staticConstructor = "of")
public class AirportClosed implements DomainEvent<AirportClosed> {
    EventId id;
    AirportId airportId;
    OffsetDateTime timestamp;
    @With
    Long sequenceNumber;

    public static AirportClosed of(AirportId airportId, OffsetDateTime timestamp) {
        return AirportClosed.of(EventId.of(), airportId, timestamp, null);
    }

    @Override
    public EventType getType() {
        return AirportEvent.AIRPORT_CLOSED;
    }
}

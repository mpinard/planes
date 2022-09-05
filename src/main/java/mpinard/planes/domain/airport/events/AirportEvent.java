package mpinard.planes.domain.airport.events;

import mpinard.planes.domain.event.DomainEventType;

public enum AirportEvent implements DomainEventType {
    AIRPORT_OPENED,
    AIRPORT_CLOSED
}

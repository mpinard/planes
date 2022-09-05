package mpinard.planes.domain.airport.events;

import mpinard.planes.domain.event.EventType;

public enum AirportEvent implements EventType {
    AIRPORT_OPENED,
    AIRPORT_CLOSED
}

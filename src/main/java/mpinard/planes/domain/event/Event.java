package mpinard.planes.domain.event;

import java.time.OffsetDateTime;

public interface Event {

    EventId getId();

    EventType getType();

    OffsetDateTime getTimestamp();

}

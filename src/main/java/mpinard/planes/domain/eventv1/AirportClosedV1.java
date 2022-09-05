package mpinard.planes.domain.eventv1;

import lombok.Value;
import lombok.With;

@Value(staticConstructor = "of")
public class AirportClosedV1 implements DomainEventV1<AirportClosedV1> {
    DomainEventIdV1 id;
    AirportIdV1 airportId;
    @With
    Long sequenceNumber;
    @With
    boolean replay;

    public static AirportClosedV1 of(AirportIdV1 airportId) {
        return AirportClosedV1.of(DomainEventIdV1.of(), airportId, null, false);
    }

    @Override
    public DomainEventTypeV1 getType() {
        return AirportEventV1.AIRPORT_CLOSED;
    }
}

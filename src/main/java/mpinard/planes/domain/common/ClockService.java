package mpinard.planes.domain.common;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.Clock;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@AllArgsConstructor(staticName = "of")
@FieldDefaults(makeFinal = true)
public class ClockService {
    private Clock clock;

    public OffsetDateTime nowAsOffsetDateTime() {
        return clock.instant().atOffset(ZoneOffset.UTC);
    }

}

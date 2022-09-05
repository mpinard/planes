package mpinard.planes.domain.common;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.assertj.core.api.Assertions.assertThat;

public class ClockServiceTest {
    private final Clock clock = Clock.fixed(Instant.parse("2007-12-03T10:15:30.00Z"), ZoneOffset.UTC);
    private final ClockService clockService = ClockService.of(clock);

    @Test
    public void When_NowAsOffsetDateTime_Expect_TimeFromWrappedClock() {
        assertThat(clockService.nowAsOffsetDateTime()).isEqualTo(OffsetDateTime.of(2007, 12, 3, 10, 15, 30, 0, ZoneOffset.UTC));
    }

}
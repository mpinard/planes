package mpinard.planes.domain.common;

import org.junit.jupiter.api.Test;

import java.time.Clock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class GameClockTest {

    @Test
    public void When_ClockCreated_Expect_TimeIsZero() {
        assertThat(GameClock.of().getTime()).isEqualTo(0);
    }

    @Test
    public void When_ClockCreatedWithTime_Expect_TimeIsSame() {
        assertThat(GameClock.of(5).getTime()).isEqualTo(5);
    }

    @Test
    public void When_ClockCreatedWithNegativeTime_Expect_IllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> GameClock.of(-1))
            .withMessage("Time must not be negative");
    }

    @Test
    public void When_ClockIncremented_Expect_OneTimeUnitAdded() {
        GameClock gameClock = GameClock.of();

        assertThat(gameClock.incrementAndGetTime()).isEqualTo(1);
        assertThat(gameClock.getTime()).isEqualTo(1);

        assertThat(gameClock.incrementAndGetTime()).isEqualTo(2);
        assertThat(gameClock.getTime()).isEqualTo(2);

        assertThat(gameClock.incrementAndGetTime()).isEqualTo(3);
        assertThat(gameClock.getTime()).isEqualTo(3);
    }

}
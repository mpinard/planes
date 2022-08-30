package mpinard.planes.domain.common;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;

import java.util.concurrent.atomic.AtomicInteger;

@Value
public class GameClock {
    @Getter(value = AccessLevel.PRIVATE)
    private AtomicInteger internalTime;

    public static GameClock of() {
        return of(0);
    }

    public static GameClock of(int time) {
        if (time < 0) {
            throw new IllegalArgumentException("Time must not be negative");
        }

        return new GameClock(new AtomicInteger(time));
    }

    public int getTime() {
        return internalTime.get();
    }

    public int incrementAndGetTime() {
        return internalTime.incrementAndGet();
    }

}

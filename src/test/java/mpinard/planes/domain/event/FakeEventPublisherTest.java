package mpinard.planes.domain.event;

import mpinard.planes.domain.airport.events.AirportId;
import mpinard.planes.domain.airport.events.AirportOpened;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.assertj.core.api.Assertions.assertThat;

public class FakeEventPublisherTest {

    private static final OffsetDateTime TIME_ONE = OffsetDateTime.of(2007, 12, 3, 10, 15, 30, 0, ZoneOffset.UTC);

    private final FakeDomainEventRepository domainEventRepository = FakeDomainEventRepository.of();
    private final FakeEventPublisher eventPublisher = FakeEventPublisher.of(domainEventRepository);

    @Test
    public void When_PublishSingleEvent_Expect_EventSavedInRepository() {
        AirportOpened event = AirportOpened.of(AirportId.of(), TIME_ONE);
        AirportOpened savedEvent = event.withSequenceNumber(1L);

        assertThat(eventPublisher.publish(event)).hasValue(savedEvent);
        assertThat(domainEventRepository.eventsAfter(null).collectList().block()).containsExactly(savedEvent);
        assertThat(domainEventRepository.eventsAfter(event.getId()).collectList().block()).isEmpty();

    }

}
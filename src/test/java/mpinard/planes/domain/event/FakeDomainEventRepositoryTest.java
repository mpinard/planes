package mpinard.planes.domain.event;

import mpinard.planes.domain.airport.events.AirportClosed;
import mpinard.planes.domain.airport.events.AirportId;
import mpinard.planes.domain.airport.events.AirportOpened;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.assertj.core.api.Assertions.assertThat;

public class FakeDomainEventRepositoryTest {

    private static final OffsetDateTime TIME_ONE = OffsetDateTime.of(2007, 12, 3, 10, 15, 30, 0, ZoneOffset.UTC);
    private static final OffsetDateTime TIME_TWO = TIME_ONE.plusSeconds(1);
    private static final OffsetDateTime TIME_THREE = TIME_TWO.plusSeconds(1);

    private final FakeDomainEventRepository domainEventRepository = FakeDomainEventRepository.of();

    @Test
    public void When_SaveSingleEvent_Expect_EventsAfterEventIdToBeEmpty() {
        AirportOpened event = AirportOpened.of(AirportId.of(), TIME_ONE);
        assertThat(domainEventRepository.save(event)).hasValue(event.withSequenceNumber(1L));
        assertThat(domainEventRepository.eventsAfter(event.getId()).collectList().block()).isEmpty();
    }

    @Test
    public void When_SaveSingleEvent_Expect_EventsAfterNullToIncludeEvents() {
        AirportOpened event = AirportOpened.of(AirportId.of(), TIME_ONE);
        AirportOpened savedEvent = event.withSequenceNumber(1L);
        assertThat(domainEventRepository.save(event)).hasValue(savedEvent);
        assertThat(domainEventRepository.eventsAfter(null).collectList().block()).containsExactly(savedEvent);
    }

    @Test
    public void When_SaveMultipleEvents_Expect_EventsAfterToIncludeOnlyEventsAfterId() {
        AirportOpened event1 = AirportOpened.of(AirportId.of(), TIME_ONE);
        AirportClosed event2 = AirportClosed.of(AirportId.of(), TIME_TWO);
        AirportOpened event3 = AirportOpened.of(AirportId.of(), TIME_THREE);
        AirportOpened savedEvent1 = event1.withSequenceNumber(1L);
        AirportClosed savedEvent2 = event2.withSequenceNumber(2L);
        AirportOpened savedEvent3 = event3.withSequenceNumber(3L);

        assertThat(domainEventRepository.save(event1)).hasValue(savedEvent1);
        assertThat(domainEventRepository.save(event2)).hasValue(savedEvent2);
        assertThat(domainEventRepository.save(event3)).hasValue(savedEvent3);

        assertThat(domainEventRepository.eventsAfter(null).collectList().block()).containsExactly(savedEvent1, savedEvent2, savedEvent3);
        assertThat(domainEventRepository.eventsAfter(savedEvent1.getId()).collectList().block()).containsExactly(savedEvent2, savedEvent3);
        assertThat(domainEventRepository.eventsAfter(savedEvent2.getId()).collectList().block()).containsExactly(savedEvent3);
        assertThat(domainEventRepository.eventsAfter(savedEvent3.getId()).collectList().block()).isEmpty();

        // eventsAfter unknown EventId also returns empty
        assertThat(domainEventRepository.eventsAfter(EventId.of()).collectList().block()).isEmpty();
    }

    @Test
    public void When_SaveEventWithExistingEventId_Expect_EventIgnoredAndEmptyOptionalReturned() {
        AirportOpened event1 = AirportOpened.of(AirportId.of(), TIME_ONE);
        AirportOpened savedEvent1 = event1.withSequenceNumber(1L);

        domainEventRepository.save(event1);
        assertThat(domainEventRepository.save(AirportOpened.of(event1.getId(), AirportId.of(), TIME_TWO, null))).isEmpty();

        assertThat(domainEventRepository.eventsAfter(null).collectList().block()).containsExactly(savedEvent1);
    }


}
package mpinard.planes.domain.eventv1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FakeDomainEventRepositoryV1Test {

    private final FakeDomainEventRepositoryV1 domainEventRepository = new FakeDomainEventRepositoryV1();

    @Test
    public void When_SaveEvent_Expect_StreamEventsPublishes() {
        AirportOpenedV1 event = AirportOpenedV1.of(AirportIdV1.of());
        domainEventRepository.save(event);
        domainEventRepository.close();

        assertThat(domainEventRepository.streamEvents()
            .collectList()
            .block()).containsExactly(event.withSequenceNumber(1L));
    }

    @Test
    public void When_SaveMultipleEvents_Expect_StreamEventsPublishes() {
        AirportOpenedV1 firstEvent = AirportOpenedV1.of(AirportIdV1.of());
        AirportClosedV1 secondEvent = AirportClosedV1.of(AirportIdV1.of());
        domainEventRepository.save(firstEvent);
        domainEventRepository.save(secondEvent);
        domainEventRepository.close();

        assertThat(domainEventRepository.streamEvents()
            .collectList()
            .block()).containsExactly(firstEvent.withSequenceNumber(1L), secondEvent.withSequenceNumber(2L));
    }

    @Test
    public void When_ReplaySingleEvent_Expect_EventReplayedThenSavedEventsStreamed() {
        AirportOpenedV1 replayedEvent = AirportOpenedV1.of(AirportIdV1.of());
        AirportOpenedV1 firstEvent = AirportOpenedV1.of(AirportIdV1.of());
        AirportClosedV1 secondEvent = AirportClosedV1.of(AirportIdV1.of());
        domainEventRepository.loadEvents(List.of(replayedEvent));
        domainEventRepository.replaySavedEvents();
        domainEventRepository.save(firstEvent);
        domainEventRepository.save(secondEvent);
        domainEventRepository.close();

        assertThat(domainEventRepository.streamEvents()
            .collectList()
            .block()).containsExactly(
                replayedEvent.withSequenceNumber(1L).withReplay(true),
                firstEvent.withSequenceNumber(2L),
                secondEvent.withSequenceNumber(3L));
    }

    @Test
    public void When_ReplayMultipleEvents_Expect_EventsReplayedThenSavedEventsStreamed() {
        AirportOpenedV1 replayedEvent1 = AirportOpenedV1.of(AirportIdV1.of());
        AirportClosedV1 replayedEvent2 = AirportClosedV1.of(AirportIdV1.of());
        AirportOpenedV1 firstEvent = AirportOpenedV1.of(AirportIdV1.of());
        AirportClosedV1 secondEvent = AirportClosedV1.of(AirportIdV1.of());
        domainEventRepository.loadEvents(List.of(replayedEvent1, replayedEvent2));
        domainEventRepository.replaySavedEvents();
        domainEventRepository.save(firstEvent);
        domainEventRepository.save(secondEvent);
        domainEventRepository.close();

        assertThat(domainEventRepository.streamEvents()
            .collectList()
            .block()).containsExactly(
            replayedEvent1.withSequenceNumber(1L).withReplay(true),
            replayedEvent2.withSequenceNumber(2L).withReplay(true),
            firstEvent.withSequenceNumber(3L),
            secondEvent.withSequenceNumber(4L));
    }




}
package mpinard.planes.domain.event;

import mpinard.planes.domain.airport.events.AirportClosed;
import mpinard.planes.domain.airport.events.AirportId;
import mpinard.planes.domain.airport.events.AirportOpened;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FakeDomainEventRepositoryTest {

    private final FakeDomainEventRepository domainEventRepository = new FakeDomainEventRepository();

    @Test
    public void When_SaveEvent_Expect_StreamEventsPublishes() {
        AirportOpened event = AirportOpened.of(AirportId.of());
        domainEventRepository.save(event);
        domainEventRepository.close();

        assertThat(domainEventRepository.streamEvents()
            .collectList()
            .block()).containsExactly(event.withSequenceNumber(1L));
    }

    @Test
    public void When_SaveMultipleEvents_Expect_StreamEventsPublishes() {
        AirportOpened firstEvent = AirportOpened.of(AirportId.of());
        AirportClosed secondEvent = AirportClosed.of(AirportId.of());
        domainEventRepository.save(firstEvent);
        domainEventRepository.save(secondEvent);
        domainEventRepository.close();

        assertThat(domainEventRepository.streamEvents()
            .collectList()
            .block()).containsExactly(firstEvent.withSequenceNumber(1L), secondEvent.withSequenceNumber(2L));
    }

    @Test
    public void When_ReplaySingleEvent_Expect_EventReplayedThenSavedEventsStreamed() {
        AirportOpened replayedEvent = AirportOpened.of(AirportId.of());
        AirportOpened firstEvent = AirportOpened.of(AirportId.of());
        AirportClosed secondEvent = AirportClosed.of(AirportId.of());
        domainEventRepository.loadEvents(List.of(replayedEvent));
        domainEventRepository.replayEvents();
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



}
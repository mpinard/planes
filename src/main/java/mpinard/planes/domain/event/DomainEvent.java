package mpinard.planes.domain.event;

public interface DomainEvent<E> {
    DomainEventId getId();
    DomainEventType getType();

    default int getVersion() {
        return 1;
    }

    Long getSequenceNumber();

    boolean isReplay();

    E withSequenceNumber(Long sequenceNumber);

    E withReplay(boolean replay);

}

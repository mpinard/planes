package mpinard.planes.domain.event;

public interface DomainEvent<E> extends Event {

    default int getVersion() {
        return 1;
    }

    Long getSequenceNumber();

    E withSequenceNumber(Long sequenceNumber);
}

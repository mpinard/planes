package mpinard.planes.domain.eventv1;

public interface DomainEventV1<E> {
    DomainEventIdV1 getId();
    DomainEventTypeV1 getType();

    default int getVersion() {
        return 1;
    }

    Long getSequenceNumber();

    boolean isReplay();

    E withSequenceNumber(Long sequenceNumber);

    E withReplay(boolean replay);

}

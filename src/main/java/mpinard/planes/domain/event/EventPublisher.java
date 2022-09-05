package mpinard.planes.domain.event;

public interface EventPublisher {

    void publish(ApplicationEvent event);

    <E extends DomainEvent<E>> DomainEvent<E> publish(DomainEvent<E> event);
}

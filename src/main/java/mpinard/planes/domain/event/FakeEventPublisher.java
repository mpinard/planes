package mpinard.planes.domain.event;

public class FakeEventPublisher implements EventPublisher {
    @Override
    public void publish(ApplicationEvent event) {

    }

    @Override
    public <E extends DomainEvent<E>> DomainEvent<E> publish(DomainEvent<E> event) {
        return null;
    }
}

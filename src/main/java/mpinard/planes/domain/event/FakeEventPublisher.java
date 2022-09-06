package mpinard.planes.domain.event;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Optional;

@AllArgsConstructor(staticName = "of")
@FieldDefaults(makeFinal = true)
public class FakeEventPublisher implements EventPublisher {

    private DomainEventRepository domainEventRepository;

    @Override
    public void publish(ApplicationEvent event) {

    }

    @Override
    public <E extends DomainEvent<E>> Optional<DomainEvent<E>> publish(DomainEvent<E> event) {
        return domainEventRepository.save(event);
    }
}

package mpinard.planes.domain.event;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.tomcat.util.net.WriteBuffer;
import org.checkerframework.checker.units.qual.C;
import reactor.core.publisher.Sinks;

import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Consumer;
import java.util.stream.Stream;

@AllArgsConstructor
@FieldDefaults(makeFinal = true)
public class FakeDomainEventPublisher implements DomainEventPublisher {
    private DomainEventRepository domainEventRepository;

    private ConcurrentMap<DomainEventType, List<DomainEventSubscription>> subscriptions = new ConcurrentHashMap<>();

    public void startNotifications() {
        domainEventRepository.streamEvents()
            .map(this::handleEvent)
            .blockLast();
    }

    @Override
    public DomainEventSubscriptionId subscribe(DomainEventType eventType, Consumer<? super DomainEvent<?>> eventConsumer) {
        DomainEventSubscription subscription = DomainEventSubscription.of(DomainEventSubscriptionId.of(), eventConsumer);

        // TODO: Extract list helper
        subscriptions.merge(eventType, List.of(subscription), (key, oldValue) -> Stream.concat(oldValue.stream(), Stream.of(subscription)).toList());

        return subscription.getId();
    }

    @Override
    public <E extends DomainEvent<E>> DomainEvent<E> publish(DomainEvent<E> event) {
        return domainEventRepository.save(event);
    }

    private DomainEvent<?> handleEvent(DomainEvent<?> event) {
        Optional.ofNullable(subscriptions.get(event.getType()))
            .ifPresent(theSubscriptions -> theSubscriptions.forEach(subcription ->
                subcription.notify(event)
            ));

        return event;
    }

}

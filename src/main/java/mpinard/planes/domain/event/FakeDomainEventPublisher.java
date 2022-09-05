package mpinard.planes.domain.event;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Consumer;
import java.util.stream.Stream;

@AllArgsConstructor
@FieldDefaults(makeFinal = true)
@Slf4j
public class FakeDomainEventPublisher implements DomainEventPublisher {
    private DomainEventRepository domainEventRepository;

    private ConcurrentMap<DomainEventType, List<DomainEventSubscription>> subscriptions = new ConcurrentHashMap<>();

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

    public void startNotifications() {
        domainEventRepository.streamEvents()
            .map(this::handleEvent)
            .blockLast();
    }

    private DomainEvent<?> handleEvent(DomainEvent<?> event) {
        Optional.ofNullable(subscriptions.get(event.getType()))
            .ifPresent(theSubscriptions -> theSubscriptions.forEach(subcription -> {
                try {
                    subcription.notify(event);
                } catch (RuntimeException e) {
                    log.error("Error processing event {}", event, e);
                }
            }));

        return event;
    }

}

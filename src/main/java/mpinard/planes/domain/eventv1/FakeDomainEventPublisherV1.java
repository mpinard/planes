package mpinard.planes.domain.eventv1;

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
public class FakeDomainEventPublisherV1 implements DomainEventPublisherV1 {
    private DomainEventRepositoryV1 domainEventRepositoryV1;

    private ConcurrentMap<DomainEventTypeV1, List<DomainEventSubscriptionV1>> subscriptions = new ConcurrentHashMap<>();

    @Override
    public DomainEventSubscriptionId subscribe(DomainEventTypeV1 eventType, Consumer<? super DomainEventV1<?>> eventConsumer) {
        DomainEventSubscriptionV1 subscription = DomainEventSubscriptionV1.of(DomainEventSubscriptionId.of(), eventConsumer);

        // TODO: Extract list helper
        subscriptions.merge(eventType, List.of(subscription), (key, oldValue) -> Stream.concat(oldValue.stream(), Stream.of(subscription)).toList());

        return subscription.getId();
    }

    @Override
    public <E extends DomainEventV1<E>> DomainEventV1<E> publish(DomainEventV1<E> event) {
        return domainEventRepositoryV1.save(event);
    }

    public void startNotifications() {
        domainEventRepositoryV1.streamEvents()
            .map(this::handleEvent)
            .blockLast();
    }

    private DomainEventV1<?> handleEvent(DomainEventV1<?> event) {
        Optional.ofNullable(subscriptions.get(event.getType()))
            .ifPresent(theSubscriptions -> theSubscriptions.forEach(subscription -> subscription.notify(event)));

        return event;
    }

}

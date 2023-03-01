package produccion.events;


import generic.DomainEvent;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import produccion.events.data.Notification;
import produccion.gateways.EventBus;
import produccion.serializer.JSONMapper;

@Component
public class RabbitMqEventBus implements EventBus {

    public static final String EXCHANGE = "ControlProduccion-producto";
    public static final String ROUTING_KEY = "events.routing.key";
    private final JSONMapper serializer;
    private final RabbitTemplate rabbitTemplate;
    public RabbitMqEventBus(JSONMapper serializer, RabbitTemplate rabbitTemplate) {
        this.serializer = serializer;
        this.rabbitTemplate = rabbitTemplate;
    }
    @Override
    public void publish(DomainEvent event) {
        var notification = new Notification(
                event.getClass().getTypeName(),
                serializer.writeToJson(event)
        );
        rabbitTemplate.convertAndSend(
                this.EXCHANGE, this.ROUTING_KEY, notification.serialize().getBytes()
        );
    }
    @Override
    public void publishError(Throwable errorEvent) {
    }
}

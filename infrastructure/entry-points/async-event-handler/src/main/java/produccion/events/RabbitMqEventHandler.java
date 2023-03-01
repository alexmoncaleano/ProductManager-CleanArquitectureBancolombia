package produccion.events;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import produccion.events.data.Notification;
import produccion.serializer.JSONMapper;
import produccion.serializer.JSONMapperImpl;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

@Component
public class RabbitMqEventHandler {

    public static final String EVENTS_QUEUE = "events.queue";

    private final Logger logger = Logger.getLogger("RabbitMqEventHandler");
    private final JSONMapper mapper = new JSONMapperImpl();

    //private final AddCommentEventUseCase useCase;

    //public RabbitMqEventHandler(AddCommentEventUseCase useCase) {
    //    this.useCase = useCase;
    //}

    @RabbitListener(queues = EVENTS_QUEUE)
    public void listener(String message) throws ClassNotFoundException {
        Notification notification = Notification.from(message);
        if(notification.getType()
                .equals("produccion.events.ProductCreated")){
            logger.info(notification.toString());
            //this.useCase.apply(Mono
            //                .just((PostCreated) mapper.readFromJson(notification.getBody(),
            //                        PostCreated.class)))
            //        .subscribe();
        }else{
            logger.info("we currently don't have a listener for that event " +notification.toString());
        }
    }
}

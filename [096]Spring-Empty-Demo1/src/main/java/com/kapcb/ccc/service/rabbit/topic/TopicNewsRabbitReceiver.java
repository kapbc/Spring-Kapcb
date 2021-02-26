import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * <a>Title: TopicMessagesRabbitReceiver </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/25-10:37
 */
@Component
@RabbitListener(queues = "")
public class TopicMessagesRabbitReceiver {

    private static final Logger log = LoggerFactory.getLogger(TopicMessagesRabbitReceiver.class);

    @RabbitHandler
    public void processTopicMessagesRabbitReceiveMessage(Map message) {
        log.info("=======This is TopicMessagesExchange======");
        log.info("receive message from rabbit");
        log.info("The message received from topic.messages is : " + message);
        log.info("=======================================");
    }
}

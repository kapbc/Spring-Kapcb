import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * <a>Title: FanoutRabbitReceiverC </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/25-11:16
 */
@Component
@RabbitListener(queues = "")
public class FanoutRabbitReceiverC {

    private static final Logger log = LoggerFactory.getLogger(FanoutRabbitReceiverC.class);

    @RabbitHandler
    public void processTopicMessagesRabbitReceiveMessage(Map message) {
        log.info("=======This is Fanout C Exchange======");
        log.info("receive message from rabbit");
        log.info("The message received from route key is : " + message);
        log.info("=======================================");
    }
}

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * <a>Title: FanoutRabbitReceiver </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/25-11:14
 */
@Component
@RabbitListener(queues = "")
public class FanoutRabbitReceiverA {

    private static final Logger log = LoggerFactory.getLogger(FanoutRabbitReceiverA.class);

    @RabbitHandler
    public void processFanoutMessagesRabbitReceiveMessage(Map message) {
        log.info("=======This is Fanout A Exchange======");
        log.info("receive message from rabbit");
        log.info("The message received from route key is : " + message);
        log.info("=======================================");
    }
}

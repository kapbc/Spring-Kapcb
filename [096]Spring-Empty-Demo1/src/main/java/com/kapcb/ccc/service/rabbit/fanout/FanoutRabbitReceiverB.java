import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * <a>Title: FanoutRabbitReceiverB </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/25-11:16
 */
@Component
@RabbitListener(queues = "")
public class FanoutRabbitReceiverB {

    private static final Logger log = LoggerFactory.getLogger(FanoutRabbitReceiverB.class);

    @RabbitHandler
    public void processFanoutMessagesRabbitReceiveMessage(Map message) {
        log.info("=======This is Fanout B Exchange======");
        log.info("receive message from rabbit");
        log.info("The message received from route key 'globalsource.fanout.b' is : " + message);
        log.info("=======================================");
    }
}

import com.fasterxml.jackson.databind.ObjectMapper;
import com.globalsources.rabbitmq.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * <a>Title: DirectRabbitReceiver </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/25-9:49
 */
@Component
@RabbitListener(queues = "")
public class DirectRabbitReceiver {

    private static final Logger log = LoggerFactory.getLogger(DirectRabbitReceiver.class);


    @RabbitHandler
    public void processDirectRabbitReceiveMessage(Map message) {
        log.info("=======This is DirectExchange One======");
        log.info("receive message from rabbit");
        log.info("The message received from direct is : " + message);
        log.info("=======================================");
    }

    @RabbitHandler
    public void processDirectRabbitReceiveJsonMessage(@Payload String jsonObject) throws IOException {
        log.info("the message from rabbit is : " + jsonObject);
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(jsonObject.getBytes(StandardCharsets.UTF_8.toString()), User.class);
        log.info("the user name is : " + user.getUsername());
        log.info("the user id is : " + user.getUserId());
        log.info("the user age is : " + user.getAge());
        log.info("the user email is : " + user.getEmail());
        System.out.println("user = " + user);
    }
}

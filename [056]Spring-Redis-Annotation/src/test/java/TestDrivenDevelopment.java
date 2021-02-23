import com.kapcb.ccc.message.IRabbitMQProducer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;

/**
 * <a>Title: TestDrivenDevelopment </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/23-9:24
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:spring/spring.xml", "classpath:spring/rabbitmq.xml"})
public class TestDrivenDevelopment {

    private static final Logger log = LoggerFactory.getLogger(TestDrivenDevelopment.class);

    @Autowired
    private IRabbitMQProducer rabbitmqProducer;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final int INITIAL_CAPACITY = 4;
    private static final String QUEUE_KEY = "test_queue_key";

    @Test
    public void send() {
        Map<String, Object> messageMap = new HashMap<>(INITIAL_CAPACITY);
        messageMap.put("kapcb", "Hello, RabbitMQ!");
        if (rabbitmqProducer.sendMessageToQueue(QUEUE_KEY, messageMap)) {
            log.info("test send message to rabbitmq success");
            return;
        }
        log.info("test send message to rabbitmq fail");
    }

    @Test
    public void testSend() {
        Map<String, Object> messageMap = new HashMap<>(INITIAL_CAPACITY);
        messageMap.put("kapcb", "Hello, RabbitMQ!");
        rabbitTemplate.convertAndSend("", messageMap);
    }
}

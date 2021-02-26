import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;


/**
 * <a>Title: RabbitDirectSender </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 * <p>
 * https://blog.csdn.net/qq_35387940/article/details/100514134?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522161421383916780261945325%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=161421383916780261945325&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_v2~rank_v29-1-100514134.pc_search_result_before_js&utm_term=SpringBoot%E6%95%B4%E5%90%88RabbitMQ%EF%BC%8C%E7%94%A8%E5%BF%83%E7%9C%8B%E5%AE%8C%E8%BF%99%E4%B8%80%E7%AF%87
 * https://github.com/KillMonkey/Springboot4RabbitMQ
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/25-14:29
 */
@Component(value = "rabbitDirectSender")
public class RabbitDirectSender implements DirectSender {

    private static final Logger log = LoggerFactory.getLogger(RabbitDirectSender.class);

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitDirectSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void senderRabbitDirectMessage(String exchange, String routingKey, User user) {
        log.info("begin to send message to rabbit");
        CorrelationData correlationData = new CorrelationData(user.getUserId());
        log.info("the json String of user is : " + user);
        rabbitTemplate.convertAndSend(exchange, routingKey, Objects.requireNonNull(JsonUtil.convertObjectToString(user)), correlationData);
    }
}

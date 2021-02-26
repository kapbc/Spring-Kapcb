import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <a>Title: TopicRabbitConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/25-10:13
 */
@Configuration
public class TopicRabbitConfiguration {

    private static final Logger log = LoggerFactory.getLogger(TopicRabbitConfiguration.class);

    public static final String ROUTE_KEY_TOPIC_NEWS = "";
    public static final String ROUTE_KEY_TOPIC_MESSAGES = "";

    @Bean
    public Queue newsQueue() {
        return new Queue("", true, false, false);
    }

    @Bean
    public Queue messagesQueue() {
        return new Queue("", true, false, false);
    }

    @Bean
    public TopicExchange rabbitTopicExchange() {
        return new TopicExchange("", true, false);
    }

    @Bean
    public Binding bindingRabbitTopicOne() {
        return BindingBuilder
                .bind(newsQueue())
                .to(rabbitTopicExchange())
                .with(ROUTE_KEY_TOPIC_NEWS);
    }

    @Bean
    public Binding bindingRabbitTopicTwo() {
        return BindingBuilder
                .bind(messagesQueue())
                .to(rabbitTopicExchange())
                .with("");
    }
}

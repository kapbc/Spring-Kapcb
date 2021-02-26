import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <a>Title: DirectRabbiConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/25-9:44
 */
@Configuration
public class DirectRabbiConfiguration {

    private static final Logger log = LoggerFactory.getLogger(DirectRabbiConfiguration.class);

    @Bean
    public Queue rabbitDirectQueue() {
        return new Queue("", true, false, false);
    }

    @Bean
    public DirectExchange rabbitDirectExchange() {
        return new DirectExchange("", true, false);
    }

    @Bean
    public Binding bindingRabbitDirect() {
        return BindingBuilder
                .bind(rabbitDirectQueue())
                .to(rabbitDirectExchange())
                .with("");
    }
}

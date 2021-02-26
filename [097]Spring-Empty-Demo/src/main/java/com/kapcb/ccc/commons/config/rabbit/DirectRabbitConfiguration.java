import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <a>Title: DirectRabbitConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/25-9:06
 */
@Configuration
public class DirectRabbitConfiguration {

    @Bean
    public Queue rabbitDirectQueue() {
        return new Queue("", true, false, false);
    }

    @Bean
    public DirectExchange rabbitDirectExchange() {
        return new DirectExchange("", true, false);
    }

    @Bean
    public DirectExchange lonelyDirectExchange() {
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

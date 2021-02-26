import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * <a>Title: FanoutRabbitConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/25-10:53
 */
@Configuration
public class FanoutRabbitConfiguration {

    private static final Logger log = LoggerFactory.getLogger(FanoutRabbitConfiguration.class);

    @Bean
    public Queue fanoutQueueA() {
        return new Queue("");
    }

    @Bean
    public Queue fanoutQueueB() {
        return new Queue("");
    }

    @Bean
    public Queue fanoutQueueC() {
        return new Queue("");
    }

    @Bean
    public FanoutExchange RabbitFanoutExchange() {
        return new FanoutExchange("");
    }

    @Bean
    public Binding bindingFonoutQueueA() {
        return BindingBuilder.bind(fanoutQueueA()).to(RabbitFanoutExchange());
    }

    @Bean
    public Binding bindingFonoutQueueB() {
        return BindingBuilder.bind(fanoutQueueB()).to(RabbitFanoutExchange());
    }

    @Bean
    public Binding bindingFonoutQueueC() {
        return BindingBuilder.bind(fanoutQueueC()).to(RabbitFanoutExchange());
    }
}

package com.kapcb.ccc.commons.config.exchange;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <a>Title: DirectExchange </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/26 21:44
 */
@Slf4j
@Configuration
public class RabbitDirectExchange {

    @Bean(value = "directExchangeOne")
    public DirectExchange directExchangeOne() {
        return new DirectExchange("directExchangeOne", true, false);
    }

    @Bean(value = "directExchangeTwo")
    public DirectExchange directExchangeTwo() {
        return new DirectExchange("directExchangeTwo", true, false);
    }

    @Bean(value = "directQueueOne")
    public Queue directQueueOne() {
        return new Queue("directQueueOne", true, false, false);
    }

    @Bean(value = "directQueueTwo")
    public Queue directQueueTwo() {
        return new Queue("directQueueTwo", true, false, false);
    }

    @Bean
    public Binding directQueueBingingOne(@Qualifier(value = "directQueueOne") Queue directQueueOne, @Qualifier(value = "directExchangeOne") DirectExchange directExchangeOne) {
        return BindingBuilder.bind(directQueueOne).to(directExchangeOne).with("rabbit.direct.one");
    }

    @Bean
    public Binding directQueueBindingTwo(@Qualifier(value = "directQueueTwo") Queue directQueueTwo, @Qualifier(value = "directExchangeTwo") DirectExchange directExchangeTwo) {
        return BindingBuilder.bind(directQueueTwo).to(directExchangeTwo).with("rabbit.direct.two");
    }
}

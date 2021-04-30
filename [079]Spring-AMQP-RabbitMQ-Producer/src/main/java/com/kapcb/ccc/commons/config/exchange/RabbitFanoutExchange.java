package com.kapcb.ccc.commons.config.exchange;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <a>Title: RabbitFanoutExchange </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/27 10:06
 */
@Slf4j
@Configuration
public class RabbitFanoutExchange {

    @Bean(value = "fanoutExchangeOne")
    public FanoutExchange fanoutExchangeOne() {
        log.info("begin to create rabbit exchange bean of fanoutExchangeOne...");
        return new FanoutExchange("fanoutExchangeOne", true, false);
    }

    @Bean(value = "fanoutQueueOne")
    public Queue fanoutQueueOne() {
        log.info("begin to create rabbit queue bean of fanoutQueueOne...");
        return new Queue("fanoutQueueOne", true, false, false);
    }

    @Bean(value = "fanoutQueueTwo")
    public Queue fanoutQueueTwo() {
        log.info("begin to create rabbit queue bean of fanoutQueueTwo...");
        return new Queue("fanoutQueueTwo", true, false, false);
    }

    @Bean(value = "fanoutQueueThree")
    public Queue fanoutQueueThree() {
        log.info("begin to create rabbit queue bean of fanoutQueueThree...");
        return new Queue("fanoutQueueThree", true, false, false);
    }

    @Bean
    public Binding fanoutQueueBindingOne(@Qualifier(value = "fanoutQueueOne") Queue fanoutQueueOne, @Qualifier(value = "fanoutExchangeOne") FanoutExchange fanoutExchangeOne) {
        log.info("begin to binding queue fanoutQueueOne to fanoutExchangeOne...");
        return BindingBuilder.bind(fanoutExchangeOne).to(fanoutExchangeOne);
    }

    @Bean
    public Binding fanoutQueueBindingTwo(@Qualifier(value = "fanoutQueueTwo") Queue fanoutQueueTwo, @Qualifier(value = "fanoutExchangeOne") FanoutExchange fanoutExchangeOne) {
        log.info("begin to binding queue fanoutQueueTwo to fanoutExchangeOne...");
        return BindingBuilder.bind(fanoutQueueTwo).to(fanoutExchangeOne);
    }

    @Bean
    public Binding fanoutQueueBindingThree(@Qualifier(value = "fanoutQueueThree") Queue fanoutQueueThree, @Qualifier(value = "fanoutExchangeOne") FanoutExchange fanoutExchangeOne) {
        log.info("begin to binding queue fanoutQueueThree to fanoutExchangeOne...");
        return BindingBuilder.bind(fanoutQueueThree).to(fanoutExchangeOne);
    }
}
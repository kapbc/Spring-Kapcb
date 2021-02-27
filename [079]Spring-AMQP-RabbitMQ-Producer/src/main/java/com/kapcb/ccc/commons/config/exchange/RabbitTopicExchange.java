package com.kapcb.ccc.commons.config.exchange;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <a>Title: RabbitTopicExchange </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/27 10:06
 */
@Slf4j
@Configuration
public class RabbitTopicExchange {

    @Bean(value = "topicExchangeOne")
    public TopicExchange topicExchangeOne() {
        log.info("begin to create rabbit exchange bean of topicExchangeOne...");
        return new TopicExchange("topicExchangeOne", true, false);
    }

    @Bean(value = "topicQueueOne")
    public Queue topicQueueOne() {
        log.info("begin to create rabbit queue bean of topicQueueOne...");
        return new Queue("topicQueueOne", true, false, false);
    }

    @Bean(value = "topicQueueTwo")
    public Queue topicQueueTwo() {
        log.info("begin to create rabbit queue bean of topicQueueTwo...");
        return new Queue("topicQueueTwo", true, false, false);
    }

    @Bean
    public Binding topicQueueBindingOne(@Qualifier(value = "topicQueueOne") Queue topicQueueOne, @Qualifier(value = "topicExchangeOne") TopicExchange topicExchangeOne) {
        log.info("begin to binding topicQueueOne to  topicExchangeOne...");
        return BindingBuilder.bind(topicQueueOne).to(topicExchangeOne).with("rabbit.topic.one");
    }

    @Bean
    public Binding topicQueueBindingTwo(@Qualifier(value = "topicQueueTwo") Queue topicQueueTwo, @Qualifier(value = "topicExchangeOne") TopicExchange topicExchangeOne) {
        log.info("begin to binding topicQueueTwo to  topicExchangeOne...");
        return BindingBuilder.bind(topicQueueTwo).to(topicExchangeOne).with("rabbit.topic.#");
    }
}

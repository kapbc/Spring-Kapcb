package com.kapcb.ccc.commons.config.exchange;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
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
        return new TopicExchange("topicExchangeOne", true, false);
    }

    @Bean(value = "topicExchangeTwo")
    public TopicExchange topicExchangeTwo() {
        return new TopicExchange("topicExchangeTwo", true, false);
    }

    @Bean(value = "topicQueueOne")
    public Queue topicQueueOne() {
        return new Queue("topicQueueOne", true, false, false);
    }

    @Bean(value = "topicQueueTwo")
    public Queue topicQueueTwo() {
        return new Queue("topicQueueTwo", true, false, false);
    }
}

package com.kapcb.ccc.commons.config;

import com.kapcb.ccc.commons.conditional.RabbitMqMessageConverterCondition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * <a>Title: Spring-Kapcb </a>
 * <a>Author: Kapcb <a>
 * <a>Description: Rabbit Configuration <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/5/1 21:26
 */
@Slf4j
@Configuration
public class RabbitConfiguration {

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Conditional(value = {RabbitMqMessageConverterCondition.class})
    public RabbitTemplate rabbitTemplate(){

    }
}

package com.kapcb.ccc.commons.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.util.concurrent.SettableListenableFuture;

import java.util.Objects;

/**
 * <a>Title: RabbitConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/26 21:44
 */
@Slf4j
@Configuration
public class RabbitConfiguration {

    @Bean
    public MessageConverter messageConverter() {
        log.info("begin to create bean of Jackson2JsonMessageConverter for rabbit...");
        return new Jackson2JsonMessageConverter();
    }

    @Bean(value = "rabbitTemplate")
    @Scope(value = "prototype")
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        rabbitTemplate.setMandatory(true);


        rabbitTemplate.setConfirmCallback(((correlationData, ack, cause) -> {
            if (ack) {
                if (Objects.nonNull(correlationData)) {
                    SettableListenableFuture<CorrelationData.Confirm> future = correlationData.getFuture();
                    Message returnedMessage = correlationData.getReturnedMessage();
                    String id = correlationData.getId();
                    log.info("the correlationData's id is : " + id);
                    log.info("the correlationData's future is : " + future);
                    log.info("the correlationData's returnedMessage is : " + returnedMessage);
                }
            } else {
                /**
                 * 消费者消息接收失败，进行补偿机制
                 * 失败消息存库，待后续重新发送
                 */
            }
        }));

        /**
         * 消息发送失败
         * 失败时按业务 选择从新投递或者丢弃
         */
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            log.info("RabbitReturnCallback        message : " + message);
            log.info("RabbitReturnCallback        replyCode : " + replyCode);
            log.info("RabbitReturnCallback        replyText : " + replyText);
            log.info("RabbitReturnCallback        exchange : " + exchange);
            log.info("RabbitReturnCallback        routingKey : " + routingKey);
            log.info("the message consumer have received the message!");
        }); 

        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
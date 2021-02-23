package com.globalsource.rabbitmq.commons.config;

import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory;

/**
 * <a>Title: RabbitMQConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 * 优雅解决消息序列化
 * https://blog.csdn.net/future_spring/article/details/106690434?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_title-2&spm=1001.2101.3001.4242
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/23-10:45
 */
@Configuration
public class RabbitConfiguration implements RabbitListenerConfigurer {

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * RabbitMQ消费者 反序列化配置
     *
     * @param rabbitListenerEndpointRegistrar RabbitListenerEndpointRegistrar
     */
    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
        rabbitListenerEndpointRegistrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
    }

    @Bean
    MessageHandlerMethodFactory messageHandlerMethodFactory() {
        DefaultMessageHandlerMethodFactory messageHandlerMethodFactory = new DefaultMessageHandlerMethodFactory();
        messageHandlerMethodFactory.setMessageConverter(mappingJackson2MessageConverter());
        return messageHandlerMethodFactory;
    }

    @Bean
    public MappingJackson2MessageConverter mappingJackson2MessageConverter() {
        return new MappingJackson2MessageConverter();
    }
}

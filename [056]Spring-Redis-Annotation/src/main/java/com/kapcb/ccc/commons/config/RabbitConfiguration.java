package com.kapcb.ccc.commons.config;

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
 *
 * RabbitMQ
 * 反序列化： https://blog.csdn.net/sswltt/article/details/108868480?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522161426374816780264026615%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=161426374816780264026615&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_v2~times_rank-4-108868480.pc_search_result_hbase_insert&utm_term=RabbitMQ%E4%BC%A0%E9%80%92Bean
 * 
 * 接受消息 https://blog.csdn.net/wuhuayangs/article/details/84861773?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522161426374816780264026615%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=161426374816780264026615&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_v2~times_rank-5-84861773.pc_search_result_hbase_insert&utm_term=RabbitMQ%E4%BC%A0%E9%80%92Bean
 * 
 * 
 * 优雅解决消息序列化
 * https://blog.csdn.net/future_spring/article/details/106690434?utm_medium=distribute.pc_relevant.none-task-blog-baidujs_title-2&spm=1001.2101.3001.4242
 * 
 * Jenkins自动打包部署
 * https://blog.csdn.net/ming19951224/article/details/80958761?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.control&dist_request_id=e7375d82-2218-49ba-8a0b-7097ad7cd820&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.control
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

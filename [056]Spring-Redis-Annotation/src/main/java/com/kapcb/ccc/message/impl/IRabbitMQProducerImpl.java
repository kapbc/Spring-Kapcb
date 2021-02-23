package com.kapcb.ccc.message.impl;

import com.kapcb.ccc.message.IRabbitMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <a>Title: RabbitMQProducerImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/23-9:11
 */
@Service(value = "rabbitmqProducer")
public class IRabbitMQProducerImpl implements IRabbitMQProducer {

    private static final Logger log = LoggerFactory.getLogger(IRabbitMQProducerImpl.class);

    private final AmqpTemplate amqpTemplate;

    @Autowired
    public IRabbitMQProducerImpl(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    /**
     * convertAndSend：将Java对象转换为消息发送到匹配Key的交换机中Exchange，
     * 由于配置了JSON转换，这里是将Java对象转换成JSON字符串的形式。
     *
     * @param queueKey String
     * @param object   Object
     * @return boolean
     */
    @Override
    public boolean sendMessageToQueue(String queueKey, Object object) {
        log.info("begin to process send message to queue...");
        try {
            amqpTemplate.convertAndSend(queueKey, object);
            log.info("process rabbitmq convert and send success!");
            return true;
        } catch (Exception e) {
            log.error("process send message to queue error, the exception message is : " + e.getMessage(), e);
        }
        log.info("process send message to queue fail!");
        return false;
    }
}

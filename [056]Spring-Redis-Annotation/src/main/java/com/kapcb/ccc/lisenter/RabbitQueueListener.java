package com.kapcb.ccc.lisenter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

/**
 * <a>Title: RabbitQueueListener </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/23-9:19
 */
@Component(value = "rabbitQueueListener")
public class RabbitQueueListener implements MessageListener {

    private static final Logger log = LoggerFactory.getLogger(RabbitQueueListener.class);

    @Override
    public void onMessage(Message message) {
        log.info("rabbit queue listener on message...");
        try {
            log.info("============================");
            log.info("a message was detected from rabbit queue, the message is : " + message.toString());
            log.info("============================");
        } catch (Exception e) {
            log.error("rabbit queue message detected error, the exception message is : " + e.getMessage());
        }
    }
}

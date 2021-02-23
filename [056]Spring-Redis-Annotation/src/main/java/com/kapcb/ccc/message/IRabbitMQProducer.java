package com.kapcb.ccc.message;

/**
 * <a>Title: RabbitMQProducer </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/23-9:09
 */
public interface IRabbitMQProducer {

    /**
     * 发送消息到指定队列中
     *
     * @param queueKey String
     * @param object   Object
     * @return boolean
     */
    public boolean sendMessageToQueue(String queueKey, Object object);
}

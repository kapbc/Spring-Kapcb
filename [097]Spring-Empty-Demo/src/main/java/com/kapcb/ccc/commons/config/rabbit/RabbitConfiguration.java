import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <a>Title: RabbitConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/25-8:39
 */
@Configuration
public class RabbitConfiguration {

    private static final Logger log = LoggerFactory.getLogger(RabbitConfiguration.class);

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * 生产者推送消息的消息确认调用回调函数已经完毕
     * <p>
     * 推送消息存在四种情况：
     * ①消息推送到server，但是在server里找不到交换机
     * ②消息推送到server，找到交换机了，但是没找到队列
     * ③消息推送到sever，交换机和队列啥都没找到
     * ④消息推送成功
     *
     * @param connectionFactory
     * @return
     */
    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        /**
         * 设置开启Mandatory才能触发回调函数，无论推送消息结果如何都强制调用回调函数
         */
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            log.info("ConfirmCallBack:        correlationData : " + correlationData);
            log.info("ConfirmCallBack:        ack : " + ack);
            log.info("ConfirmCallBack:        cause : " + cause);
            if (correlationData != null) {
                String messageId = correlationData.getId();
                if (ack) {
                    log.info("the messageId is : " + messageId);
                } else {
                    /**
                     * 失败进行具体的后续处理：重试 或者补偿等手段
                     */
                    log.info("the message is error!");
                }
            }

        });
        rabbitTemplate.setMessageConverter(messageConverter());
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            log.info("ReturnCallback:        message : " + message);
            log.info("ReturnCallback:        replyCode : " + replyCode);
            log.info("ReturnCallback:        replyText : " + replyText);
            log.info("ReturnCallback:        exchange : " + exchange);
            log.info("ReturnCallback:        routingKey : " + routingKey);
        });
        return rabbitTemplate;
    }

}

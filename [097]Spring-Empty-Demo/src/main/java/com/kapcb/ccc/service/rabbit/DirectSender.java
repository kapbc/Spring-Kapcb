/**
 * <a>Title: DirectSender </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/25-14:50
 */
public interface DirectSender {

    /**
     * send message to rabbit
     *
     * @param exchange   String
     * @param routingKey String
     * @param user       User
     */
    void senderRabbitDirectMessage(String exchange, String routingKey, User user);
}

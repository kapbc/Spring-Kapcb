import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;


@RestController
@RequestMapping(path = "test/rabbitmq/")
public class SendMessageController {

    private static final Logger log = LoggerFactory.getLogger(SendMessageController.class);

    private static final int INITIAL_CAPACITY = 6;
    private static final String MESSAGE_SEND_ID = "messageId";
    private static final String MESSAGE_SEND_TIME = "createTime";
    private static final String MESSAGE_SEND_DATA = "messageData";
    private static final String MESSAGE_SEND_FROM = "messageAuthor";
    private static final String REQUEST_INVALID_RETURN_MESSAGE = "the param can't be null";
    private static final String REQUEST_FAIL_RETURN_MESSAGE = "process send message to rabbitmq fail";
    private static final String REQUEST_SUCCESS_RETURN_MESSAGE = "process send message to rabbitmq success";
    private static final String MESSAGE_SEND_DATA_BASE_TOPIC = "Hello Rabbit! This message is from TopicExchange!";
    private static final String MESSAGE_SEND_DATA_BASE_DIRECT = "Hello Rabbit! This message is from DirectExchange!";
    private static final String MESSAGE_SEND_DATA_BASE_FANOUT = "Hello Rabbit! This message is from FanoutExchange!";

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final RabbitTemplate rabbitTemplate;
    private final RabbitDirectSender rabbitDirectSender;

    @Autowired
    public SendMessageController(RabbitTemplate rabbitTemplate, RabbitDirectSender rabbitDirectSender) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitDirectSender = rabbitDirectSender;
    }


    @GetMapping(path = "/direct/{name}", produces = "application/json;charset=utf-8")
    public String sendDirectMessage(@PathVariable(value = "name") String name) {
        Map<String, Object> messageMap = generatorMessageForRabbitmq(name, MESSAGE_SEND_DATA_BASE_DIRECT);
        if (messageMap.isEmpty()) {
            return REQUEST_INVALID_RETURN_MESSAGE;
        }
        rabbitTemplate.convertAndSend("", "", messageMap);
        log.info(REQUEST_SUCCESS_RETURN_MESSAGE);
        return REQUEST_SUCCESS_RETURN_MESSAGE;
    }


    @GetMapping(path = "/topicOne/{name}", produces = "application/json;charset=utf-8")
    public String sendTopicNews(@PathVariable(value = "name") String name) {
        Map<String, Object> messageMap = generatorMessageForRabbitmq(name, MESSAGE_SEND_DATA_BASE_TOPIC);
        if (messageMap.isEmpty()) {
            return REQUEST_INVALID_RETURN_MESSAGE;
        }
        rabbitTemplate.convertAndSend("", "", messageMap);
        log.info(REQUEST_SUCCESS_RETURN_MESSAGE);
        return REQUEST_SUCCESS_RETURN_MESSAGE;

    }


    @GetMapping(path = "/topicTwo/{name}", produces = "application/json;charset=utf-8")
    public String sendTopicMessages(@PathVariable(value = "name") String name) {
        Map<String, Object> messageMap = generatorMessageForRabbitmq(name, MESSAGE_SEND_DATA_BASE_TOPIC);
        if (messageMap.isEmpty()) {
            return REQUEST_INVALID_RETURN_MESSAGE;
        }
        rabbitTemplate.convertAndSend("", "", messageMap);
        log.info(REQUEST_SUCCESS_RETURN_MESSAGE);
        return REQUEST_SUCCESS_RETURN_MESSAGE;
    }


    @GetMapping(path = "/fanout/{name}", produces = "application/json;charset=utf-8")
    public String sendFanoutMessages(@PathVariable(value = "name") String name) {
        Map<String, Object> messageMap = generatorMessageForRabbitmq(name, MESSAGE_SEND_DATA_BASE_FANOUT);
        if (messageMap.isEmpty()) {
            return REQUEST_INVALID_RETURN_MESSAGE;
        }
        rabbitTemplate.convertAndSend("", null, messageMap);
        log.info(REQUEST_SUCCESS_RETURN_MESSAGE);
        return REQUEST_SUCCESS_RETURN_MESSAGE;
    }

    /**
     * http://127.0.0.1:8081/test/rabbitmq/messageAck/mike
     * ①消息推送到server，但是在server里找不到交换机
     * ①这种情况触发的是 ConfirmCallback 回调函数。
     *
     * @param name
     * @return
     */
    @GetMapping(path = "messageAck/{name}", produces = "application/json;charset=utf-8")
    public String messageAck(@PathVariable(value = "name") String name) {
        Map<String, Object> messageMap = generatorMessageForRabbitmq(name, "ack test for no exchange");
        if (messageMap.isEmpty()) {
            return REQUEST_INVALID_RETURN_MESSAGE;
        }
        rabbitTemplate.convertAndSend("", "", messageMap);
        log.info(REQUEST_SUCCESS_RETURN_MESSAGE);
        return REQUEST_SUCCESS_RETURN_MESSAGE;
    }

    /**
     * http://127.0.0.1:8081/test/rabbitmq/messageAck2/mike
     * ②消息推送到server，找到交换机了，但是没找到队列
     * ②这种情况触发的是 ConfirmCallback和RetrunCallback两个回调函数。
     *
     * @param name
     * @return
     */
    @GetMapping(path = "messageAck2/{name}", produces = "application/json;charset=utf-8")
    public String messageAck2(@PathVariable(value = "name") String name) {
        Map<String, Object> messageMap = generatorMessageForRabbitmq(name, "ack test for no queue for exchange");
        if (messageMap.isEmpty()) {
            return REQUEST_INVALID_RETURN_MESSAGE;
        }
        rabbitTemplate.convertAndSend("", "", messageMap);
        log.info(REQUEST_SUCCESS_RETURN_MESSAGE);
        return REQUEST_SUCCESS_RETURN_MESSAGE;
    }

    /**
     * http://127.0.0.1:8081/test/rabbitmq/bean/mike
     *
     * @param name
     * @return
     */
    @GetMapping(path = "bean/{name}", produces = "application/json;charset=utf-8")
    public String bean(@PathVariable(value = "name") String name) {
        log.info("the path variable name is : " + name);
        LocalDateTime now = LocalDateTime.now();
        String currentTime = DATE_TIME_FORMATTER.format(now);
        log.info("current time is : " + currentTime);
        User user = new User();
        user.setUsername(name);
        user.setAge(18);
        String generatorId = UUID.randomUUID().toString();
        log.info("the generatorId is : " + generatorId);
        CorrelationData correlationData = new CorrelationData(generatorId);
        rabbitTemplate.convertAndSend("", "", Objects.requireNonNull(JsonUtil.convertObjectToString(user)), correlationData);
        log.info(REQUEST_SUCCESS_RETURN_MESSAGE);
        return REQUEST_SUCCESS_RETURN_MESSAGE;
    }

    /**
     * http://127.0.0.1:8081/test/rabbitmq/testBean/mike
     *
     * @param name
     * @return
     */
    @GetMapping(path = "testBean/{name}", produces = "application/json;charset=utf-8")
    public String testBean(@PathVariable(value = "name") String name) {
        log.info("the path variable name is : " + name);
        String generatorId = UUID.randomUUID().toString();
        log.info("the generatorId is : " + generatorId);
        User user = new User();
        user.setUsername(name);
        user.setAge(18);
        user.setUserId(generatorId);
        rabbitDirectSender.senderRabbitDirectMessage("", "", user);
        log.info(REQUEST_SUCCESS_RETURN_MESSAGE);
        return REQUEST_SUCCESS_RETURN_MESSAGE;
    }

    private Map<String, Object> generatorMessageForRabbitmq(String name, String messageData) {
        if (StringUtils.isBlank(name)) {
            return Collections.emptyMap();
        }
        log.info("===============Message Send Info==================");
        log.info("the messageAuthor is : " + name);
        String messageId = UUID.randomUUID().toString();
        log.info("the messageId is : " + messageId);
        log.info("the messageData is : " + messageData);
        LocalDateTime now = LocalDateTime.now();
        String currentLocalDateTime = DATE_TIME_FORMATTER.format(now);
        log.info("the message createTime is : " + currentLocalDateTime);
        log.info("the messageAuthor is : " + name);
        log.info("===============Message Send Info==================");

        Map<String, Object> messageMap = new HashMap<>(INITIAL_CAPACITY);
        messageMap.put(MESSAGE_SEND_ID, messageId);
        messageMap.put(MESSAGE_SEND_DATA, messageData);
        messageMap.put(MESSAGE_SEND_TIME, currentLocalDateTime);
        messageMap.put(MESSAGE_SEND_FROM, name);
        return messageMap;
    }
}

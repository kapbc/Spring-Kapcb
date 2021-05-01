package com.kapcb.ccc.commons.conditional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * <a>Title: Spring-Kapcb </a>
 * <a>Author: Kapcb <a>
 * <a>Description: Rabbit MQ Message Converter Conditional <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/5/1 21:36
 */
@Slf4j
@Component
public class RabbitMqMessageConverterCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        MessageConverter bean = Objects.requireNonNull(conditionContext.getBeanFactory()).getBean(MessageConverter.class);
        return Objects.nonNull(bean);
    }
}

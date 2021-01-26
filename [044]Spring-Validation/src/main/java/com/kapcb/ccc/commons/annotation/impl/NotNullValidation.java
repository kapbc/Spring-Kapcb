package com.kapcb.ccc.commons.annotation.impl;

import com.kapcb.ccc.commons.annotation.NotNull;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <a>Title: NotNullValidation </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/25-15:41
 */
@Aspect
@Component
public class NotNullValidation {

    private static final Logger log = LoggerFactory.getLogger(NotNullValidation.class);


    /**
     * @Pointcut(value = "execution(public * com.kapcb.ccc.controller.*.*(@com.kapcb.ccc.commons.annotation.NotNull (*), ..))||" +
     * "execution(public * com.kapcb.ccc.controller.*.*(*, @com.kapcb.ccc.commons.annotation.NotNull (*)))||" +
     * "execution(public * com.kapcb.ccc.controller.*.*(@com.kapcb.ccc.commons.annotation.NotNull (*), @com.kapcb.ccc.commons.annotation.NotNull (*)))")
     */
    @Pointcut(value = "execution(public * com.kapcb.ccc.controller..*.*(..)) && @annotation(com.kapcb.ccc.commons.annotation.Judgement)")
    public void cut() {
    }

    @Around(value = "cut()")
    public Object process(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Signature signature = proceedingJoinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        Parameter[] parameters = method.getParameters();

        Object[] arguments = proceedingJoinPoint.getArgs();
        List<String> messageList = new ArrayList<>();
        if (ArrayUtils.isNotEmpty(parameters)) {
            for (int i = 0; i < parameters.length; i++) {
                String message = null;
                boolean value = false;

                Annotation[] annotations = parameters[i].getAnnotations();
                if (ArrayUtils.isNotEmpty(annotations)) {
                    for (Annotation annotation : annotations) {
                        if (annotation instanceof NotNull) {
                            NotNull notNull = (NotNull) annotation;
                            message = notNull.message();
                            value = notNull.value();
                            log.info("the message is : " + message);
                            log.info("the value is : " + value);
                        }
                    }
                    if (!value) {
                        continue;
                    }
                    if (Objects.equals(null, arguments[i]) || StringUtils.isBlank(String.valueOf(arguments[i]))) {
                        messageList.add(message);
                    }
                }
            }
        }
        if (!messageList.isEmpty()) {
            String result = messageList.stream().map(String::trim).collect(Collectors.joining(", "));
            log.info("the validation result is : " + result);
            return result;
        }
        log.info("kapcb nb");
        return proceedingJoinPoint.proceed();
    }
}

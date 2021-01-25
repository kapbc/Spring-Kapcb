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
import java.util.Arrays;
import java.util.List;

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


    @Pointcut(value = "execution(public * com.kapcb.ccc.controller.*.*(@com.kapcb.ccc.commons.annotation.NotNull (*), ..))||" +
            "execution(public * com.kapcb.ccc.controller.*.*(*, @com.kapcb.ccc.commons.annotation.NotNull (*)))||" +
            "execution(public * com.kapcb.ccc.controller.*.*(@com.kapcb.ccc.commons.annotation.NotNull (*), @com.kapcb.ccc.commons.annotation.NotNull (*)))")
    public void cut() {
    }

    @Around(value = "cut()")
    public Object process(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Signature signature = proceedingJoinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        Parameter[] parameters = method.getParameters();

        if (ArrayUtils.isNotEmpty(parameters)) {
            for (Parameter parameter : parameters) {
                String message = null;
                boolean value = false;
                log.info("the parameter uis : " + parameter.toString());
                if (parameter.getAnnotatedType() instanceof NotNull) {
                    NotNull notNull = parameter.getAnnotation(NotNull.class);
                    message = notNull.message();
                    value = notNull.value();
                    log.info("the message is : " + message);
                    log.info("the value is : " + value);
                }
                if (!value) {
                    continue;
                }
                Object[] args = proceedingJoinPoint.getArgs();
                for (Object arg : args) {
                    String a = (String) arg;
                    log.info("the arg is : " + a);
                    if (StringUtils.isBlank(a) || StringUtils.equals(null, a)) {
                        return "the required params should not be null or empty or blank";
                    }
                }
            }
        }


        List<String> list = new ArrayList<>();
        Object[] args = proceedingJoinPoint.getArgs();
        String s = Arrays.toString(args);
        log.info("the args array is : " + s);
        for (Object arg : proceedingJoinPoint.getArgs()) {
            String a = (String) arg;
            if (StringUtils.isBlank(a) || StringUtils.equals(null, a)) {
                return "the required params should not be null or empty or blank";
            }
        }
        log.info("kapcb nb");
        return proceedingJoinPoint.proceed();
    }
}

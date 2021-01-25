package com.kapcb.ccc.commons.annotation.impl;

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

import java.lang.reflect.Method;

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

    @Pointcut(value = "execution(public * com.kapcb.ccc.controller.*.*(@com.kapcb.ccc.commons.annotation.NotNull (*), ..))")
    public void cut() {
    }

    @Around(value = "cut()")
    public Object process(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Signature signature = proceedingJoinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        log.info("the method is : " + method.toString());
        String a = (String) proceedingJoinPoint.getArgs()[0];
        log.info("the arg is : " + a);
        boolean value = false;
        String message = null;

        if (StringUtils.isBlank(a) || StringUtils.equals(null, a)) {
            return "the required params should not be null or empty or blank";
        }
        log.info("kapcb nb");
        return proceedingJoinPoint.proceed();
    }
}

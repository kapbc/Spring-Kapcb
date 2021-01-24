package com.kapcb.ccc.commons.annotation.impl;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * <a>Title: VerifiedBean </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/24 21:10
 */
@Scope
@Slf4j
@Aspect
@Component
public class VerifiedBean {

    @Pointcut(value = "@annotation(com.kapcb.ccc.commons.annotation.Verified)&&execution(* com.kapcb.ccc.controller.*.*(..))")
    public void verified() {
        log.info("come into the point cut...");
    }

    @Around(value = "verified()")
    public Object toVerified(ProceedingJoinPoint proceedingJoinPoint) {
        Object aThis = proceedingJoinPoint.getThis();
        log.info("the this is : " + aThis);
        Class<?> aClass = proceedingJoinPoint.getTarget().getClass();
        log.info("the target is : " + aClass);
        return new Object();
    }
}

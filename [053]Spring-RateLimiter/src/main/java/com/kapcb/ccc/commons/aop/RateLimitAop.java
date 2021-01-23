package com.kapcb.ccc.commons.aop;

import com.google.common.util.concurrent.RateLimiter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * <a>Title: RateLimitAop </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/23 11:44
 */
@Slf4j
@Scope
@Aspect
@Component
@RequiredArgsConstructor
public class RateLimitAop {

    private final HttpServletResponse response;

    private final RateLimiter rateLimiter = RateLimiter.create(1);

    @Pointcut(value = "@annotation(com.kapcb.ccc.commons.annotation.ApiRateLimit)")
    public void serviceLimit() {
    }

    @Around(value = "serviceLimit()")
    @SneakyThrows(value = Throwable.class)
    public Object around(ProceedingJoinPoint joinPoint) {
        boolean flag = rateLimiter.tryAcquire();
        Object obj = null;
        if (flag) {
            obj = joinPoint.proceed();
        } else {
            String message = "fail";
            output(response, message);
        }
        log.info("the flag is : " + flag + "; the obj is : " + obj);
        return obj;
    }

    private void output(HttpServletResponse response, String message) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        try (PrintWriter writer = response.getWriter();) {
            writer.write(message);
        }
    }
}

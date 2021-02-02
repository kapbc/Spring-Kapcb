package com.kapcb.ccc.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * <a>Title: LoginPointCut </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/2 22:41
 */
@Aspect
@Component
public class LoginPointCut {

    /**
     * 抽取可重用的切入点表达式
     * 增强com.kapcb.ccc.service.impl.ICalculatorServiceImpl 下的 任意两个参数列表都为int类型的方法
     */
    @Pointcut(value = "execution(public int com.kapcb.ccc.service.impl.ICalculatorServiceImpl.*(int,int))")
    public void pointCut() {
    }

    @Around(value = "pointCut()")
    public Object Around(ProceedingJoinPoint proceedingJoinPoint) {
        Object proceed = null;
        /**
         * 获取传递给被切方法的参数
         */
        Object[] args = proceedingJoinPoint.getArgs();
        /**
         * 获取被切方法的方法签名
         */
        Signature signature = proceedingJoinPoint.getSignature();
        /**
         * 获取方法签名的String字符串
         */
        String name = signature.getName();

        try {
            /**
             * @Before 前置通知
             */
            System.out.println("Around advance, the method is : " + name + " begin to process ...");
            /**
             * 执行目标方法
             */
            proceed = proceedingJoinPoint.proceed(args);
            /**
             * @AfterReturning()
             */
            System.out.println("Around advance after returning, the method is : " + name + " the return value is : " + proceed);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}

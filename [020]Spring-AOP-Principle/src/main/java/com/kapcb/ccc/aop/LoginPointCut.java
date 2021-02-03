package com.kapcb.ccc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

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
             * @Before() 前置通知
             */
            System.out.println("Around advance, the method : " + name + " begin to process ...");
            /**
             * 执行目标方法
             */
            proceed = proceedingJoinPoint.proceed(args);
            /**
             * @AfterReturning()
             */
            System.out.println("Around advance after returning, the method : " + name + " the return value is : " + proceed);
        } catch (Throwable throwable) {
            /**
             * @AfterThrowing()
             */
            System.out.println("Around advance, the method : " + name + " throw exception, the exception message is : " + throwable.getMessage());
            throwable.printStackTrace();
        } finally {
            /**
             * @After()
             */
            System.out.println("Around advance, the method : " + name + " is end...");
        }

        /**
         * 反射调用的返回值一定需要返回
         * 否则外部无法获取
         */
        return proceed;
    }


    /**
     * 执行目标方法之前运行
     * 写切入表达式:"execution(访问权限符 返回值类型 方法签名)"
     */
    @Before(value = "pointCut()")
    public static void beforeAdvance(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        List<Object> arguments = Arrays.asList(args);
        System.out.println("The method " + name + "is begin to run, the args is : " + arguments);
    }
}

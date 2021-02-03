package com.kapcb.ccc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
        /**
         * 获取目标方法运行时使用的参数
         */
        Object[] args = joinPoint.getArgs();
        /**
         * 获取方法签名
         * signature对象可以获取方法的签名，方法名，修饰符，返回值类型
         */
        Signature signature = joinPoint.getSignature();
        /**
         * 获取方法名
         */
        String name = signature.getName();
        /**
         * 参数列表数组转集合
         */
        List<Object> arguments = Arrays.asList(args);
        System.out.println("The method " + name + " is begin to run, the args is : " + arguments);
    }

    @After(value = "pointCut()")
    public static void afterAdvance(JoinPoint joinPoint) {
        /**
         * 获取目标方法运行时使用的参数
         */
        Object[] args = joinPoint.getArgs();
        /**
         * 获取方法签名
         * signature对象可以获取方法的签名，方法名，修饰符，返回值类型
         */
        Signature signature = joinPoint.getSignature();
        /**
         * 获取方法名
         */
        String name = signature.getName();
        /**
         * 参数列表数组转集合
         */
        List<Object> arguments = Arrays.asList(args);
        System.out.println("The method " + name + " is begin to run, the args is : " + arguments);
    }

    /**
     * 目标方法执行出现异常的时候运行
     * <p>
     * 告诉Spring 哪个参数是异常
     * 使用throwing = "exception",指定抛出异常
     */
    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public static void afterThrowAdvance(JoinPoint joinPoint, Exception exception) {
        /**
         * 获取目标方法运行时使用的参数
         */
        Object[] args = joinPoint.getArgs();
        /**
         * 获取方法签名
         * signature对象可以获取方法的签名，方法名，修饰符，返回值类型
         */
        Signature signature = joinPoint.getSignature();
        /**
         * 获取方法名
         */
        String name = signature.getName();
        /**
         * 参数列表数组转集合
         */
        List<Object> arguments = Arrays.asList(args);
        System.out.println("The method " + name + " is begin to throw exception, the exception is : " + exception.getMessage() + ", the args is : " + arguments);
    }

    /**
     * 目标方法执行结束后运行
     * 告诉Spring 哪个参数是返回结果
     * 使用returning = "result",指定返回结果
     */
    @AfterReturning(value = "pointCut()", returning = "result")
    public static void afterReturnAdvance(JoinPoint joinPoint, Object result) {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("The method " + name + " is process success, the return result is : " + result);
    }
}

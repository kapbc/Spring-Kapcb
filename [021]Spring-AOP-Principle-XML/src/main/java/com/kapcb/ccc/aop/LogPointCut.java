package com.kapcb.ccc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

import java.util.Arrays;

/**
 * <a>Title: LogPointCut </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/4 21:53
 */
public class LogPointCut {

    public Object pointCut(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = null;
        /**
         * 获取目标方法运行时使用的参数
         */
        Object[] args = proceedingJoinPoint.getArgs();
        /**
         * 获取方法签名
         * signature对象可以获取方法的签名，方法名，修饰符，返回值类型
         */
        Signature signature = proceedingJoinPoint.getSignature();
        /**
         * 获取方法名
         */
        String name = signature.getName();
        try {
            // @Before()
            System.out.println("the before advance method : " + name + " is begin");
            result = proceedingJoinPoint.proceed(args);
            // @AfterReturning()
            System.out.println("the afterReturning advance method : " + name + " is begin, the arguments is : " + Arrays.toString(args));
        } catch (Exception e) {
            // @AfterThrowing()
            System.out.println("the afterThrowing advance method : " + name + " is begin, the arguments is : " + Arrays.toString(args));
            throw new RuntimeException(e.getMessage());
        } finally {
            // @After()
            System.out.println("the after advance method : " + name + " is begin, the return result is : " + result);
        }
        // 反射后调用的返回值也一定需要返回
        return result;
    }

    public static void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("the before advance method : " + name + " is begin to run, the arguments is : " + Arrays.toString(args));
    }

    public static void after(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("the after advance method : " + name + " is begin to run, the arguments is : " + Arrays.toString(args));
    }

    public static void afterReturning(JoinPoint joinPoint, Object result) {
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("the afterReturning advance method : " + name + " is begin to run, the result is : " + result);
    }

    public static void afterThrowing(JoinPoint joinPoint, Exception exception) {
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("the afterThrowing advance method : " + name + " is begin to run, the exception is : " + exception.getMessage());
    }
}

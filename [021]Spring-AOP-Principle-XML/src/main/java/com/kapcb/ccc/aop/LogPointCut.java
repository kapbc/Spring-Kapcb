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
        Object[] args = proceedingJoinPoint.getArgs();
        Signature signature = proceedingJoinPoint.getSignature();
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

    public static void afterReturning(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("the afterReturning advance method : " + name + " is begin to run, the arguments is : " + Arrays.toString(args));
    }

    public static void afterThrowing(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("the afterThrowing advance method : " + name + " is begin to run, the arguments is : " + Arrays.toString(args));
    }
}

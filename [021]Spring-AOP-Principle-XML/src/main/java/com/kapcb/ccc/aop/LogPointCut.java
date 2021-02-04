package com.kapcb.ccc.aop;

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
            System.out.println("the after advance method : " + name + " is begin, the return result is : " + result);
        }

        return result;
    }
}

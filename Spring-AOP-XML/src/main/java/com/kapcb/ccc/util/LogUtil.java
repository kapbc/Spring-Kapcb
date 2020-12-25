package com.kapcb.ccc.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

import java.util.Arrays;
import java.util.List;

/**
 * <a>Title:LogUtil</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/1 19:07
 */

public class LogUtil {


    public Object myAround(ProceedingJoinPoint point) throws Throwable {

        Object proceed = null;
        Object[] args = point.getArgs();
        Signature signature = point.getSignature();
        String name = signature.getName();
        try {
            //@Before()
            System.out.println("环绕前置通知" + name + "方法开始");
            //利用反射执行目标方法,就是 method.invoke(obj,args)；方法
            proceed = point.proceed(args);
            //@AfterReturning()
            System.out.println("环绕返回通知" + name + "方法返回，返回值" + proceed);
        } catch (Exception e) {
            //@AfterThrowing()
            System.out.println("环绕异常通知" + name + "方法出现异常，异常信息：" + e);
            //将异常抛出,给普通通知接收异常
            throw new RuntimeException("抛出异常" + e);
        } finally {
            //@After()
            System.out.println("环绕返回通知" + name + "方法结束");
        }
        //反射后调用的返回值也一定需要返回
        return proceed;
    }

    public static void logBefore(JoinPoint joinPoint) {
        //获取目标方法运行时使用的参数
        Object[] args = joinPoint.getArgs();
        //获取方法签名
        //signature对象可以获取方法的签名，方法名，修饰符，返回值类型
        Signature signature = joinPoint.getSignature();
        //获取方法名
        String name = signature.getName();
        List<Object> arg = Arrays.asList(args);
        System.out.println("【" + name + "】" + "方法开始执行了，参数列表为" + "【" + arg + "】");
    }

    /**
     * 目标方法正确执行完成之后
     */
    public static void logAfter(JoinPoint joinPoint) {
        //获取目标方法运行时使用的参数
        Object[] args = joinPoint.getArgs();
        //获取方法签名
        //signature对象可以获取方法的签名，方法名，修饰符，返回值类型
        Signature signature = joinPoint.getSignature();
        //获取方法名
        String name = signature.getName();
        List<Object> arg = Arrays.asList(args);
        System.out.println("【" + name + "】" + "方法执行完成，参数列表为" + "【" + arg + "】");
    }


    /**
     * 目标方法执行出现异常的时候运行
     * <p>
     * 告诉Spring 哪个参数是异常
     * 使用throwing = "exception",指定抛出异常
     */
    public static void logException(JoinPoint joinPoint, Exception exception) {
        //获取目标方法运行时使用的参数
        Object[] args = joinPoint.getArgs();
        //获取方法签名
        //signature对象可以获取方法的签名，方法名，修饰符，返回值类型
        Signature signature = joinPoint.getSignature();
        //获取方法名
        String name = signature.getName();
        List<Object> arg = Arrays.asList(args);
        System.out.println("运行名为" + "【" + name + "】" + "的方法出现异常,异常为：" + "【" + exception + "】" + "方法的参数列表为" + "【" + arg + "】");
    }

    /**
     * 目标方法执行结束后运行
     * 告诉Spring 哪个参数是返回结果
     * 使用returning = "result",指定返回结果
     */
    public static void logEnd(JoinPoint joinPoint, Object result) {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("【" + name + "】" + "方法运行完成" + "结果为：" + "【" + result + "】");
    }
}

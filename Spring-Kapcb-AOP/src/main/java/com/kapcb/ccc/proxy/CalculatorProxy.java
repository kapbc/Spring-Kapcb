package com.kapcb.ccc.proxy;

import com.kapcb.ccc.calculator.Calculator;
import com.kapcb.ccc.util.LogUtil;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;

/**
 * <a>Title:CalculatorProxy</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 * <p>
 * 代理对象
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/5/31 19:39
 */
public class CalculatorProxy {

    /**
     * 为传入的参数创建一个动态代理对象
     *
     * @param calculator 需要代理的对象
     * @return 代理对象
     */
    public static Calculator getProxy(final Calculator calculator) {

        /**
         * 目标方法，执行器
         */
        InvocationHandler handler = new InvocationHandler() {
            /**
             * Object proxy:代理对象，任何时候不要使用，这是给jdk使用的
             * Method method:当前将要执行的目标对象的方法
             * Object[] args:传参
             *
             * @param proxy 代理对象，任何时候不要使用，这是给jdk使用的
             * @param method 当前将要执行的目标对象的方法
             * @param args 传参
             * @return Object
             * @throws Throwable Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /**
                 * object：方法执行的对象
                 * args：参数列表
                 * 规定在内部类中使用一个外部变量需要定义为 final 修饰
                 *
                 * invoke(object,args)
                 *
                 * result目标方法执行后的返回值
                 */
                Object result = null;

                try {

                    result = method.invoke(calculator, args);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                }
                /**
                 * 返回值必须返回出去，外部才能拿到方法的结果
                 */
                return result;
            }
        };
        /**
         * 被代理对象实现的接口
         */
        Class<?>[] interfaces = calculator.getClass().getInterfaces();
        /**
         * 被代理对象的类加载器
         */
        ClassLoader loader = calculator.getClass().getClassLoader();
        /**
         * 使用 Proxy.newProxyInstance 获取一个动态代理的实例
         */
        Object proxyInstance = Proxy.newProxyInstance(loader, interfaces, handler);
        return (Calculator) proxyInstance;
    }
}

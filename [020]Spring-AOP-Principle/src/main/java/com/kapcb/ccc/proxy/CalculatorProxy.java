package com.kapcb.ccc.proxy;

import com.kapcb.ccc.service.ICalculatorService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <a>Title: CalculatorProxy </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 * <p>
 * 代理对象
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/1 22:55
 */
public class CalculatorProxy {

    /**
     * 为传入的参数创建一个动态代理对象
     *
     * @param iCalculatorService ICalculatorService 需要代理的对象
     * @return ICalculatorService 代理对象
     */
    public static ICalculatorService getProxy(final ICalculatorService iCalculatorService) {

        /**
         * 目标方法，执行器
         */
        InvocationHandler invocationHandler = new InvocationHandler() {

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
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println("this is jdk autoProxy...");
                /**
                 * object：方法执行的对象
                 * args：参数列表
                 * 规定在内部类中使用一个外部变量需要定义为 final 修饰
                 *
                 * invoke(object,args)
                 *
                 * result目标方法执行后的返回值
                 *
                 * 返回值必须返回出去，外部才能拿到方法的结果
                 */
                return method.invoke(proxy, args);
            }
        };

        /**
         * 被代理对象实现的接口
         */
        Class<?>[] interfaces = iCalculatorService.getClass().getInterfaces();

        /**
         * 被代理对象的类加载器
         */
        ClassLoader classLoader = iCalculatorService.getClass().getClassLoader();

        /**
         * 使用 Proxy.newProxyInstance 获取一个动态代理的实例
         */
        Object newProxyInstance = Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

        /**
         * 返回代理对象
         */
        return (ICalculatorService) newProxyInstance;
    }
}

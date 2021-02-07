package com.kapcb.ccc.proxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * <a>Title: CgLibAutoDynamicProxy </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/7-13:16
 */
public class CgLibAutoDynamicProxy implements MethodInterceptor {

    private static final Logger log = LoggerFactory.getLogger(CgLibAutoDynamicProxy.class);

    /**
     * 根据一个类型产生代理类，此方法不要求一定放在MethodInterceptor中
     *
     * @param clazz Class<?>
     * @return Object
     */
    public Object CreateProxyObject(Class<?> clazz) {
        /**
         * 设置cglib生成的源码目录
         */
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\");

        Enhancer enhancer = new Enhancer();

        /**
         * 设置父类
         */
        enhancer.setSuperclass(clazz);

        /**
         * 设置方法拦截处理器
         */
        enhancer.setCallback(this);

        /**
         * 创建代理对象
         */
        return enhancer.create();
    }

    /**
     * 通过反射 arg1.invoke(arg0, ...)这种方式是无法调用到父类的方法的，子类有方法重写，
     * 隐藏了父类的方法，父类的方法已经不可见，如果硬调arg1.invoke(arg0, ...)很明显会死循环。
     *
     * @param object      表示创建的代理对象
     * @param method      代理的方法
     * @param args        方法参数
     * @param methodProxy 封装了代理方法，代理对象和原对象
     * @return Object
     * @throws Throwable Throwable
     */
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        /**
         * 增强代码
         */
        log.info("the arguments is : " + ArrayUtils.toString(args));
        log.info("cglib before");
        Object result = methodProxy.invokeSuper(object, args);
        log.info("cglib after");
        return result;
    }
}

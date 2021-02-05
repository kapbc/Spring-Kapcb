package com.kapcb.ccc.proxy;

import java.lang.reflect.Proxy;

/**
 * <a>Title: UserLoginProxy </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/5 22:13
 */
@SuppressWarnings("unchecked")
public class UserLoginProxy {

    public static <T> T getProxy(final T data) {
        System.out.println("begin to get proxy...");
        UserLoginLogInvocationHandler userLoginLogInvocationHandler = new UserLoginLogInvocationHandler(data);

        ClassLoader classLoader = data.getClass().getClassLoader();

        Class<?>[] interfaces = data.getClass().getInterfaces();

        return (T) Proxy.newProxyInstance(classLoader, interfaces, userLoginLogInvocationHandler);
    }
}

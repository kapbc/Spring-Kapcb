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
public class UserLoginProxy {

    public static <T> Object getProxy(final T data) {

        UserLoginLogInvocationHandler userLoginLogInvocationHandler = new UserLoginLogInvocationHandler(data);

        ClassLoader classLoader = data.getClass().getClassLoader();

        Class<?>[] interfaces = data.getClass().getInterfaces();

        return Proxy.newProxyInstance(classLoader, interfaces, userLoginLogInvocationHandler);
    }
}

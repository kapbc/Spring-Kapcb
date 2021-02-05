package com.kapcb.ccc.proxy;

import com.sun.istack.internal.NotNull;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <a>Title: UserLoginLogInvocationHandler </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/5 22:14
 */
public class UserLoginLogInvocationHandler implements InvocationHandler {

    @NotNull
    private final Object proxyInterface;

    public UserLoginLogInvocationHandler(Object proxyInterface) {
        this.proxyInterface = proxyInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            result = method.invoke(proxyInterface, args);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            System.out.println("user login log invocation handler's method : invoke was done");
        }
        return result;
    }
}

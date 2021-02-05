package com.kapcb.ccc.proxy;

import com.sun.istack.internal.NotNull;
import org.apache.commons.lang3.ArrayUtils;
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

    /**
     * 创建代理对象，进行方法增强
     *
     * @param proxy  被代理对象
     * @param method 方法
     * @param args   传递进来的参数
     * @return 代理对象
     * @throws Throwable Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            System.out.println("the arguments will transfer to IUserService's method login is : " + ArrayUtils.toString(args));
            System.out.println("do some enhance operation before the method was invoke....");
            result = method.invoke(proxyInterface, args);
            System.out.println("do some enhance operation after the method was invoke....");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            System.out.println("user login log invocation handler's method : invoke was done");
        }
        return result;
    }

}

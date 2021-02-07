package com.kapcb.ccc;

import com.kapcb.ccc.commons.domain.User;
import com.kapcb.ccc.proxy.CgLibAutoDynamicProxy;

/**
 * <a>Title: Test </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/7-13:30
 */
public class Test {

    public static void main(String[] args) {

        CgLibAutoDynamicProxy cgLibAutoDynamicProxy = new CgLibAutoDynamicProxy();
        User user = (User) cgLibAutoDynamicProxy.CreateProxyObject(User.class);
        System.out.println("user = " + user);
        System.out.println("user.getClass() = " + user.getClass());
    }
}

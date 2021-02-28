package com.kapcb.ccc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <a>Title:Test</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/5/31 17:22
 */
@Scope(value = "")
public class Test {
    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

        Object IServiceDaoImpl1 = ioc.getBean("IServiceDaoImpl");
        Object IServiceDaoImpl = ioc.getBean("IServiceDaoImpl");
        Object IServiceImpl = ioc.getBean("IServiceImpl");
        Object SystemController = ioc.getBean("SystemController");

        System.out.println("IServiceDaoImpl1 = " + IServiceDaoImpl1);
        System.out.println(IServiceDaoImpl1 == IServiceDaoImpl);
        System.out.println("IServiceImpl = " + IServiceImpl);
        System.out.println("SystemController = " + SystemController);

    }
}

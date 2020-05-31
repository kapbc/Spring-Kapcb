package com.kapcb.ccc.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <a>Title:MyFactoryBeanTest</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/5/31 11:13
 */
public class MyFactoryBeanTest {
    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc3.xml");
        Object myFactoryBean = ioc.getBean("myFactoryBean");
        Object myFactoryBean01 = ioc.getBean("myFactoryBean");
        System.out.println("myFactoryBean = " + myFactoryBean);
        System.out.println(myFactoryBean==myFactoryBean01);
    }
}

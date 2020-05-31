package com.kapcb.ccc;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <a>Title:BeanTest</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/5/31 11:40
 */
public class BeanTest {

    public static void main(String[] args) {
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("ioc4.xml");

        Object book01 = ioc.getBean("book01");
        System.out.println("容器要关闭了····");
        ioc.close();
    }
}

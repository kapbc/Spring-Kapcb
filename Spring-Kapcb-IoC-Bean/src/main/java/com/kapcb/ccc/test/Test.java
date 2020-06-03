package com.kapcb.ccc.test;


import com.kapcb.ccc.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <a>Title:Test</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/1 21:09
 */
public class Test {
    public static void main(String[] args) {
        String configure = "applicationContext.xml";
        ApplicationContext ioc = new ClassPathXmlApplicationContext(configure);
        Person bean = ioc.getBean(Person.class);
        System.out.println(bean);
    }
}

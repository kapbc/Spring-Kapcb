package com.kapcb.ccc;

import com.kapcb.ccc.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <a>Title:TestConstructor</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/5/30 19:17
 */
public class TestConstructor {

    public static void main(String[] args) {

        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
        Person person03 = (Person) ioc.getBean("person03");
        Person person04 = (Person) ioc.getBean("person04");
        System.out.println("person03 = " + person03);
        System.out.println("person04 = " + person04);
    }
}

package com.kapcb.ccc;

import com.kapcb.ccc.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

/**
 * <a>Title:XMLAutowire</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/5/31 13:19
 */
public class XMLAutowire {

    public static void main(String[] args) {

        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person bean = (Person) ioc.getBean("person10");
        System.out.println("bean = " + bean);
    }
}

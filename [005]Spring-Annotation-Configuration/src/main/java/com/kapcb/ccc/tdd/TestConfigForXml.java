package com.kapcb.ccc.tdd;

import com.kapcb.ccc.configure.TestSpringConfigurationForXml;
import com.kapcb.ccc.domain.Person;
import com.kapcb.ccc.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <a>Title: TestConfigForXml </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/25 - 23:18
 */
public class TestConfigForXml {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(TestSpringConfigurationForXml.class);
        Person person = (Person) context.getBean("person");
        person.eat();

        User userBean = context.getBean(User.class);
        userBean.sayHello();
    }
}

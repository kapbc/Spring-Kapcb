package com.kapcb.ccc.tdd;

import com.kapcb.ccc.configure.TestSpringConfiguration;
import com.kapcb.ccc.domain.Person;
import com.kapcb.ccc.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <a>Title: TestConfig </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/25 - 17:17
 */
public class TestConfig {

    public static void main(String[] args) {

        /**
         * @Configuration 注解的 spring 容器加载方式，用AnnotationConfigApplicationContext替换ClassPathXmlApplicationContext
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(TestSpringConfiguration.class);

        /**
         * 如果是加载xml配置文件则为
         */
        // ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        /**
         * 从Spring容器中获取Bean实例
         */
        User user = (User) context.getBean("testUser");
        User userBean = context.getBean(User.class);
        user.sayHello();
        userBean.sayHello();
        System.out.println(user == userBean);


        /**
         * 从Spring容器中获取Person 的实例
         */
        Person personBean = context.getBean(Person.class);
        personBean.eat();
    }
}

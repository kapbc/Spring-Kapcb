package com.kapcb.ccc.tdd;

import com.kapcb.ccc.configure.TestSpringConfiguration;
import com.kapcb.ccc.domain.Person;
import com.kapcb.ccc.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <a>Title: TestAnnotation </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/25 - 18:13
 */
public class TestAnnotation {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestSpringConfiguration.class);
        /**
         * 获取Bean
         */
        User userBean = context.getBean(User.class);
        userBean.sayHello();

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(TestSpringConfiguration.class);
        annotationConfigApplicationContext.refresh();

        /**
         * 获取Bean
         */
        Person personBean = annotationConfigApplicationContext.getBean(Person.class);
        personBean.eat();
    }
}

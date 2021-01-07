package com.kapcb.ccc.tdd;

import com.kapcb.ccc.config.ContextConfig;
import com.kapcb.ccc.domain.Bean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <a>Title: TestDrivenDevelopment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/7 20:11
 */
public class TestDrivenDevelopment {

    private static final String SPRING_CONTEXT_CONFIG_LOCATION = "spring-beans.xml";

    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext(SPRING_CONTEXT_CONFIG_LOCATION);

        Bean bean = ioc.getBean("bean", Bean.class);
        System.out.println("bean = " + bean);
        bean.sayHello();

        Bean beanAllArgsConstructor = ioc.getBean("beanAllArgsConstructor", Bean.class);
        System.out.println("beanAllArgsConstructor = " + beanAllArgsConstructor);
        beanAllArgsConstructor.sayHello();

        Bean beanAllArgsConstructorWithOutName = ioc.getBean("beanAllArgsConstructorWithOutName", Bean.class);
        System.out.println("beanAllArgsConstructorWithOutName = " + beanAllArgsConstructorWithOutName);
        beanAllArgsConstructorWithOutName.sayHello();

        ApplicationContext iocForAnnotation = new AnnotationConfigApplicationContext(ContextConfig.class);
    }
}

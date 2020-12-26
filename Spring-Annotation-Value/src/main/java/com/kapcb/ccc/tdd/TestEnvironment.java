package com.kapcb.ccc.tdd;

import com.kapcb.ccc.configure.PropertiesConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <a>Title: TestEnvironment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/26 - 11:36
 */
public class TestEnvironment {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(PropertiesConfiguration.class);
        PropertiesConfiguration propertiesConfiguration = (PropertiesConfiguration) context.getBean("propertiesConfiguration");
        propertiesConfiguration.dataSource();
    }
}

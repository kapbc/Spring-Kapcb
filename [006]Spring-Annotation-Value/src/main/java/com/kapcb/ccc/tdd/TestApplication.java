package com.kapcb.ccc.tdd;

import com.kapcb.ccc.configure.ApplicationConfiguration;
import com.kapcb.ccc.domain.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <a>Title: TestAplication </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/26 - 13:18
 */
public class TestApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        Configuration configurationBean = context.getBean(Configuration.class);
        System.out.println("configurationBean = " + configurationBean);
    }

}

package com.kapcb.ccc.tdd;

import com.kapcb.ccc.configure.TestSpringConfigurationForNest;
import com.kapcb.ccc.domain.DataSource;
import com.kapcb.ccc.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <a>Title: TestConfigForNest </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/26 - 0:43
 */
public class TestConfigForNest {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(TestSpringConfigurationForNest.class);
        User userBean = context.getBean(User.class);
        userBean.sayHello();
        DataSource dataSourceBean = context.getBean(DataSource.class);
        System.out.println("dataSourceBean = " + dataSourceBean);
    }
}

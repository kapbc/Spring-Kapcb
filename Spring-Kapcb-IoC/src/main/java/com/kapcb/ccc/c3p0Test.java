package com.kapcb.ccc;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * <a>Title:c3p0Test</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/5/31 12:46
 */
public class c3p0Test {

    public static void main(String[] args) throws SQLException {
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("ioc5.xml");
        //从容器中获取连接池
//        DataSource dataSource = (DataSource) ioc.getBean("dataSource");

        // 2.按照类型获取组件，可以获取到这个类型下的所有实现类子类等
        DataSource bean = ioc.getBean(DataSource.class);
        System.out.println("bean = " + bean.getConnection());
    }
}

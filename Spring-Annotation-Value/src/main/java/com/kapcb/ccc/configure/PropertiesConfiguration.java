package com.kapcb.ccc.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * <a>Title: PropertiesConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/26 - 11:29
 */
@Configuration
@ComponentScan(basePackages = "com.kapcb.ccc.configure")
@PropertySource(value = "classpath:kapcb.properties")
public class PropertiesConfiguration {

    @Autowired
    private Environment environment;

    public PropertiesConfiguration() {
        System.out.println("PropertiesConfiguration Begin To Initial ...");
    }

    // @Bean(value = "sql")
    // @Scope(name = "singleton")
    public DataSource dataSource() {
        String username = environment.getProperty("spring.annotation.value.test");
        System.out.println("username = " + username);
        return null;
    }
}

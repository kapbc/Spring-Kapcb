package com.kapcb.ccc.configure;

import com.kapcb.ccc.domain.Person;
import com.kapcb.ccc.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * <a>Title: TestSpringConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/25 - 17:14
 */
@Configuration
// 添加自动扫描注解，basePackages为Person包路径
@ComponentScan(basePackages = "com.kapcb.ccc.domain")
public class TestSpringConfiguration {

    public TestSpringConfiguration() {
        System.out.println("TestSpringConfiguration Content Begin To Start Up......");
    }

    /**
     * @Bean 注解可以注册Bean, 同时也可以指定Bean的初始化和销毁的回调方法
     * @return User
     */
    @Bean(name = "testUser", initMethod = "start", destroyMethod = "cleanUp")
    @Scope(value = "prototype")
    public User user() {
        return new User();
    }
}

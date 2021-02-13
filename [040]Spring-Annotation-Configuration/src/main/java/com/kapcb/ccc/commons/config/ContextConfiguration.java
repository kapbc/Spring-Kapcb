package com.kapcb.ccc.commons.config;

import com.kapcb.ccc.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * <a>Title: ContextConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/13 9:51
 */
@Configuration
// 添加自动扫描注解，basePackages为Person包路径
@ComponentScan(basePackages = {"com.kapcb.ccc.domain"})
public class ContextConfiguration {

    private static final Logger log = LoggerFactory.getLogger(ContextConfiguration.class);

    public ContextConfiguration() {
        log.warn("the spring ioc context is initial....");
    }

    @Scope(value = "singleton")
    @Bean(value = "kapcb", initMethod = "start", destroyMethod = "cleanUp")
    public User user() {
        User user = new User();
        user.setUrl("www.kapcb.com");
        user.setUsername("kapcb");
        user.setPassword("123456");
        return user;
    }
}

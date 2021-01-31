package com.kapcb.ccc.config;

import com.kapcb.ccc.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * <a>Title: ContextBeanConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/31 22:17
 */
@Configuration
public class ContextBeanConfiguration {

    @Scope(value = "singleton")
    @Bean
    public User user() {
        User user = new User();
        user.setUsername("kapcb");
        user.setEmail("eircccallroot@163.com");
    }
}

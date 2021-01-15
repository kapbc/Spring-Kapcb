package com.kapcb.ccc.config;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * <a>Title: SpringConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/15 22:37
 */
@Slf4j
@Component
@Configuration
public class SpringConfiguration {

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        internalResourceViewResolver().setPrefix("/WEB-INF/page/");
        internalResourceViewResolver().setSuffix(".jsp");
        return internalResourceViewResolver();
    }

}

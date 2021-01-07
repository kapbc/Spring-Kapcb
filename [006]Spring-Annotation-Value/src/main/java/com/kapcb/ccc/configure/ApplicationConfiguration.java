package com.kapcb.ccc.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * <a>Title: ApplicationConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/26 - 11:43
 */
@Configuration
@ComponentScan(basePackages = "com.kapcb.ccc.domain")
public class ApplicationConfiguration {

    public ApplicationConfiguration() {
        System.out.println("ApplicationConfiguration Start Initial...");
    }

    @Bean(value = "properties")
    @Scope(value = "singleton")
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

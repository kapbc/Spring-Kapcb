package com.kapcb.ccc.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

/**
 * <a>Title: Configuration </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/26 - 11:46
 */
@Component
@PropertySources({
        @PropertySource(value = "classpath:ccc.properties",ignoreResourceNotFound = true),
        @PropertySource(value = "classpath:kapcb.properties")
})
public class Configuration {


    @Value("${spring.annotation.configuration.username}")
    private String username;

    @Value("${spring.annotation.configuration.password}")
    private String password;

    @Override
    public String toString() {
        return "Configuration{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

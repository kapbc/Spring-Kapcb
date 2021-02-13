package com.kapcb.ccc.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

/**
 * <a>Title: SystemProperties </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/13 20:39
 */
@Component(value = "systemProperties")
@PropertySources(value = {
        @PropertySource(value = "classpath:properties/kapcb.properties"),
        @PropertySource(value = "classpath:properties/system.properties"),
        @PropertySource(value = "classpath:properties/ccc.properties", ignoreResourceNotFound = true)
})
public class SystemProperties {

    @Value(value = "${spring.annotation.configuration.username}")
    private String username;

    @Value("${spring.annotation.configuration.password}")
    private String password;

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public String toString() {
        return "SystemProperties{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

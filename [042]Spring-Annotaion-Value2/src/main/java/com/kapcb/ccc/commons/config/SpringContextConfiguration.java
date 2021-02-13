package com.kapcb.ccc.commons.config;

import com.kapcb.ccc.domain.KpacbDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

/**
 * <a>Title: ContextConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/13 20:40
 */
@Configuration
@ComponentScan(basePackages = {"com.kapcb.ccc"})
@PropertySources(value = {
        @PropertySource(value = "classpath:properties/kapcb.properties"),
        @PropertySource(value = "classpath:properties/system.properties")
})
public class SpringContextConfiguration {

    @Autowired
    private Environment environment;

    private static final Logger log = LoggerFactory.getLogger(SpringContextConfiguration.class);


    @Bean(value = "kpacbDataSource")
    public KpacbDataSource kpacbDataSource() {
        KpacbDataSource kpacbDataSource = new KpacbDataSource();
        String usernameFromProperties = environment.getProperty("spring.annotation.configuration.username");
        String passwordFromProperties = environment.getProperty("spring.annotation.configuration.password");
        log.warn("the username from properties is : " + usernameFromProperties);
        log.warn("the password from properties is : " + passwordFromProperties);
        kpacbDataSource.setUsername(usernameFromProperties);
        kpacbDataSource.setPassword(passwordFromProperties);
        return kpacbDataSource;
    }
}

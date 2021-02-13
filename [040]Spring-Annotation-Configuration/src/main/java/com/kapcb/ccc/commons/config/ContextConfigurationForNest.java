package com.kapcb.ccc.commons.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <a>Title: ContextConfigurationForNest </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/13 10:07
 */
@Configuration
@ComponentScan(basePackages = {"com.kapcb.ccc.domain"})
public class ContextConfigurationForNest {

    private static final Logger log = LoggerFactory.getLogger(ContextConfigurationForNest.class);

    public ContextConfigurationForNest() {
        log.warn("spring context configuration for nest is initial...");
    }

    @Configuration
    public static class DataSourceConfiguration {


    }
}

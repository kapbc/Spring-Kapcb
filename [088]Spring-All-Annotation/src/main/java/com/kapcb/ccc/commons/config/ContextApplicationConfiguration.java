package com.kapcb.ccc.commons.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * <a>Title: ContextApplicationConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/21 18:30
 */
@Configuration
@ComponentScan
@ComponentScan(basePackages = {"com.kapcb.ccc"}, excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {EnableWebMvc.class})})
public class ContextApplicationConfiguration {

    private static final Logger log = LoggerFactory.getLogger(ContextApplicationConfiguration.class);

    public ContextApplicationConfiguration() {
        log.info("================begin to initial ContextApplicationConfiguration......================");
    }
}

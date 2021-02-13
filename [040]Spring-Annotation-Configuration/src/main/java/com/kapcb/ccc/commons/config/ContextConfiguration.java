package com.kapcb.ccc.commons.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

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
public class ContextConfiguration {

    private static final Logger log = LoggerFactory.getLogger(ContextConfiguration.class);

    public ContextConfiguration() {
        log.warn("the spring ioc context is initial....");
    }
}

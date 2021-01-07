package com.kapcb.ccc.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;

/**
 * <a>Title: Configuration </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/2 20:51
 */
@Configuration
public class SystemConfiguration {

    private static final Logger logger = Logger.getLogger(SystemConfiguration.class);

    public SystemConfiguration() {
        logger.warn("Spring Configuration is initial...");
    }
}

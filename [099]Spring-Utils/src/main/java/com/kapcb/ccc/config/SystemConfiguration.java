package com.kapcb.ccc.config;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Configuration
public class SystemConfiguration {

    public SystemConfiguration() {
        log.warn("Spring Configuration is initial...");
    }
}

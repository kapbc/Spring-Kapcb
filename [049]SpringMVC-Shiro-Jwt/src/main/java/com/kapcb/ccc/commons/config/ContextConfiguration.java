package com.kapcb.ccc.commons.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * <a>Title: ContextConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/22 20:52
 */
@Slf4j
@Configuration
@Import(ShiroConfiguration.class)
public class ContextConfiguration {


}

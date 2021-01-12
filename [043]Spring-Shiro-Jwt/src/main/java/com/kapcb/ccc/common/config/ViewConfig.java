package com.kapcb.ccc.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <a>Title: ViewConfig </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/12 23:04
 */
@Configuration
public class ViewConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/WEB-INF/page/login.jsp");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        addViewControllers(registry);
    }
}

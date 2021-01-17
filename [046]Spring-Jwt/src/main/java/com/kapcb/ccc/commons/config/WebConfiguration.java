package com.kapcb.ccc.commons.config;

import com.kapcb.ccc.commons.interceptor.HeaderTokenInterceptor;
import com.kapcb.ccc.commons.interceptor.HttpInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <a>Title: WebConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/17 22:52
 */
@Component
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HttpInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new HeaderTokenInterceptor()).addPathPatterns("/**");
    }
}

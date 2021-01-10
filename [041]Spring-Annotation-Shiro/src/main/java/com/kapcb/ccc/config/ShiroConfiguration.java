package com.kapcb.ccc.config;

import com.kapcb.ccc.commons.filter.LoginAuthorizationFilter;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.apache.shiro.mgt.SecurityManager;


import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

/**
 * <a>Title: ShiroConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/10 21:42
 */
@Slf4j
@Component
public class ShiroConfiguration {

    private static final int INITIAL_CAPACITY = 4;

    @Bean("securityManager")
    public SecurityManager securityManager() {
        return new DefaultSecurityManager();
    }

    @Bean
    public LoginAuthorizationFilter loginAuthorizationFilter() {
        return new LoginAuthorizationFilter();
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean filterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        LoginAuthorizationFilter loginAuthorizationFilter = new LoginAuthorizationFilter();
        Map<String, Filter> filtersMap = new HashMap<>(INITIAL_CAPACITY);
        filtersMap.put("authc", loginAuthorizationFilter);
        shiroFilterFactoryBean.setFilters(filtersMap);
        shiroFilterFactoryBean.setLoginUrl("/kapcb/shiro/test/login");
        shiroFilterFactoryBean.setSecurityManager();
    }


}

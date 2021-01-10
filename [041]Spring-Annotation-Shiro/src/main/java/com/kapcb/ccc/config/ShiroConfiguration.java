package com.kapcb.ccc.config;

import com.kapcb.ccc.commons.filter.LoginAuthorizationFilter;
import com.kapcb.ccc.commons.realm.UserRealm;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@Configuration
public class ShiroConfiguration {

    private static final int INITIAL_CAPACITY = 4;

    @Bean
    public SecurityManager securityManager(UserRealm userRealm) {
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(userRealm);
        return defaultSecurityManager;
    }

    @Bean
    public LoginAuthorizationFilter loginAuthorizationFilter() {
        return new LoginAuthorizationFilter();
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean filterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        Map<String, Filter> filtersMap = new HashMap<>(INITIAL_CAPACITY);
        filtersMap.put("authc", loginAuthorizationFilter());
        shiroFilterFactoryBean.setFilters(filtersMap);
        shiroFilterFactoryBean.setLoginUrl("/kapcb/shiro/test/login");
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        return shiroFilterFactoryBean;
    }


}

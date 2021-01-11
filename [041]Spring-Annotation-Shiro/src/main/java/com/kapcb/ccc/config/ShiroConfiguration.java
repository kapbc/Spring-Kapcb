package com.kapcb.ccc.config;

import com.kapcb.ccc.commons.filter.LoginAuthorizationFilter;
import com.kapcb.ccc.commons.realm.UserRealm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
@RequiredArgsConstructor
public class ShiroConfiguration {

    private static final int INITIAL_CAPACITY = 4;

    private final LoginAuthorizationFilter loginAuthorizationFilter;

    @Bean
    public SecurityManager securityManager(UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        log.warn("process the shiroFilter JNDI");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/kapcb/shiro/transmissionDoor");
        // shiroFilterFactoryBean.setSuccessUrl("");
        // shiroFilterFactoryBean.setUnauthorizedUrl("");
        Map<String, Filter> filters = new LinkedHashMap<>();
        filters.put("authc", loginAuthorizationFilter);
        shiroFilterFactoryBean.setFilters(filters);
        Map<String, String> filterChainDefinitionMap = new HashMap<>(INITIAL_CAPACITY);
        filterChainDefinitionMap.put("/index.jsp", "anon");
        filterChainDefinitionMap.put("/kapcb/shiro/v1/login", "anon");
        filterChainDefinitionMap.put("/kapcb/shiro/v1/logout", "anon");
        filterChainDefinitionMap.put("/kapcb/shiro/v1/getUserInfo", "authc");
        filterChainDefinitionMap.put("/kapcb/shiro/v2/**", "anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        log.warn("shiroFilter JNDI success");
        return shiroFilterFactoryBean;
    }
}

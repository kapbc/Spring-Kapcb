package com.kapcb.ccc.commons.config;

import com.kapcb.ccc.commons.jwt.JwtFilter;
import com.kapcb.ccc.commons.jwt.JwtRealm;
import com.kapcb.ccc.commons.shiro.ShiroRealm;
import com.kapcb.ccc.service.IPermissionService;
import com.kapcb.ccc.service.IRoleService;
import com.kapcb.ccc.service.IUserService;
import com.kapcb.ccc.service.impl.IPermissionServiceImpl;
import com.kapcb.ccc.service.impl.IRoleServiceImpl;
import com.kapcb.ccc.service.impl.IUserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.pam.FirstSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.SessionStorageEvaluator;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <a>Title: ShiroConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/21 22:52
 */
@Slf4j
@Component
@Configuration
public class ShiroConfiguration {

    @Bean
    public IUserService userService() {
        return new IUserServiceImpl();
    }

    @Bean
    public IRoleService roleService() {
        return new IRoleServiceImpl();
    }

    @Bean
    public IPermissionService permissionService() {
        return new IPermissionServiceImpl();
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    public JwtFilter jwtFilter() {
        return new JwtFilter();
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/kapcb/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("");
        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("jwtFilter", jwtFilter());
        shiroFilterFactoryBean.setFilters(filterMap);
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/kapcb/login", "anon");
        filterChainDefinitionMap.put("/kapcb/logout", "anon");
        filterChainDefinitionMap.put("/kapcb/sys/login", "anon");
        filterChainDefinitionMap.put("/kapcb/**", "jwtFilter,authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public ModularRealmAuthenticator authenticator() {
        ModularRealmAuthenticator modularRealmAuthenticator = new ModularRealmAuthenticator();
        FirstSuccessfulStrategy firstSuccessfulStrategy = new FirstSuccessfulStrategy();
        modularRealmAuthenticator.setAuthenticationStrategy(firstSuccessfulStrategy);
        return modularRealmAuthenticator;
    }

    @Bean
    public SessionStorageEvaluator sessionStorageEvaluator() {
        DefaultSessionStorageEvaluator sessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        sessionStorageEvaluator.setSessionStorageEnabled(false);
        return sessionStorageEvaluator;
    }

    @Bean
    public JwtRealm jwtRealm() {
        return new JwtRealm(userService(), roleService(), permissionService());
    }

    @Bean
    public ShiroRealm shiroRealm() {
        return new ShiroRealm(userService(), roleService(), permissionService());
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        DefaultSubjectDAO defaultSubjectDAO = new DefaultSubjectDAO();
        defaultWebSecurityManager.setSubjectDAO(defaultSubjectDAO);
        defaultWebSecurityManager.setAuthenticator(authenticator());
        defaultSubjectDAO.setSessionStorageEvaluator(sessionStorageEvaluator());

        List<Realm> realms = new ArrayList<>();
        realms.add(jwtRealm());
        realms.add(shiroRealm());
        defaultWebSecurityManager.setRealms(realms);
        return defaultWebSecurityManager;
    }
}

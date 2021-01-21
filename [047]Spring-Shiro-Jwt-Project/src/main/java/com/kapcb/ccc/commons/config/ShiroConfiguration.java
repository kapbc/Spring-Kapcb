package com.kapcb.ccc.commons.config;

import com.kapcb.ccc.commons.constants.Constant;
import com.kapcb.ccc.commons.jwt.JwtCredentialsMatchers;
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
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.FirstSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.SessionStorageEvaluator;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
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
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/20-8:25
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
    public JwtCredentialsMatchers jwtCredentialsMatchers() {
        return new JwtCredentialsMatchers();
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

    /**
     * 避免Spring将其注册为全局过滤器, 因为其作用只是希望过滤 /login 和 /logout 之外的所有请求
     *
     * @return JwtFilter
     */
    public JwtFilter jwtFilter() {
        return new JwtFilter();
    }


    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/kapcb/login");
        shiroFilterFactoryBean.setSuccessUrl("/authorized");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");
        Map<String, Filter> filtersMap = new LinkedHashMap<>();
        filtersMap.put("jwtFilter", jwtFilter());
        shiroFilterFactoryBean.setFilters(filtersMap);
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/kapcb/login", "anon");
        filterChainDefinitionMap.put("/kapcb/logout", "anon");
        filterChainDefinitionMap.put("/kapcb/sys/fail", "anon");
        filterChainDefinitionMap.put("/kapcb/sys/login", "anon");
        filterChainDefinitionMap.put("/kapcb/sys/success", "anon");
        filterChainDefinitionMap.put("/kapcb/**", "jwtFilter,authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public ModularRealmAuthenticator modularRealmAuthenticator() {
        ModularRealmAuthenticator modularRealmAuthenticator = new ModularRealmAuthenticator();
        FirstSuccessfulStrategy firstSuccessfulStrategy = new FirstSuccessfulStrategy();
        modularRealmAuthenticator.setAuthenticationStrategy(firstSuccessfulStrategy);
        return modularRealmAuthenticator;
    }

    @Bean
    public SessionStorageEvaluator sessionStorageEvaluator() {
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        return defaultSessionStorageEvaluator;
    }

    @Bean
    public JwtRealm jwtRealm() {
        return new JwtRealm(userService(), roleService(), permissionService(), jwtCredentialsMatchers());
    }

    @Bean
    public ShiroRealm shiroRealm() {
        ShiroRealm shiroRealm = new ShiroRealm(userService(), roleService(), permissionService());
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher(Constant.SHIRO_REALM_ALGORITHM.getString());
        hashedCredentialsMatcher.setHashIterations(Constant.SIXTEEN.getInt());
        shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return shiroRealm;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        DefaultSubjectDAO defaultSubjectDAO = new DefaultSubjectDAO();
        defaultSubjectDAO.setSessionStorageEvaluator(sessionStorageEvaluator());
        defaultSecurityManager.setSubjectDAO(defaultSubjectDAO);
        defaultSecurityManager.setAuthenticator(modularRealmAuthenticator());
        List<Realm> realms = new ArrayList<>();
        realms.add(jwtRealm());
        realms.add(shiroRealm());
        defaultSecurityManager.setRealms(realms);
        return defaultSecurityManager;
    }
}

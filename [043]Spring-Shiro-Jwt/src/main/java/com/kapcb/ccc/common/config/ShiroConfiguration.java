package com.kapcb.ccc.common.config;

import com.kapcb.ccc.common.filter.KapcbLoginFilter;
import com.kapcb.ccc.common.realm.UserRealm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.pam.FirstSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.SessionStorageEvaluator;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

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
 * @date 2021/1/12 20:45
 */
@Slf4j
@Component
@Configuration
@RequiredArgsConstructor
public class ShiroConfiguration {

    private static final int INITIAL_CAPACITY = 4;
    private static final String AUTHC = "authc";
    private static final String ANON = "anon";
    private static final String LOGIN_URL = "/kapcb/shiro/v2/login";
    private static final String LOGOUT_URL = "/kapcb/shiro/v2/logout";
    private static final String USER_INFO_URL = "/kapcb/shiro/v2/getUserInfo";
    private static final String UN_LOGIN_URL = "/kapcb/shiro/v2/**";
    private static final String LOGIN_PAGE_URL = "/kapcb/shiro/v2/page";
    private static final String UN_AUTHOR_URL = "/kapcb/shiro/v2/";
    private static final String LOGIN_SUCCESS_URL = "/kapcb/shiro/v2/see";

    private final KapcbLoginFilter kapcbLoginFilter;

    @Bean
    public SecurityManager securityManager(UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 交由 Spring 来自动管理 Shiro-Bean 的生命周期
     *
     * @return LifecycleBeanProcessor
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 为Shiro-Bean开启对Shiro的注解支持
     *
     * @return AuthorizationAttributeSourceAdvisor
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        return new AuthorizationAttributeSourceAdvisor();
    }

    /**
     * 生产代理, 通过代理进行控制
     *
     * @return DefaultAdvisorAutoProxyCreator
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }


    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl(LOGIN_PAGE_URL);
        shiroFilterFactoryBean.setUnauthorizedUrl(UN_AUTHOR_URL);
        shiroFilterFactoryBean.setSuccessUrl(LOGIN_SUCCESS_URL);
        Map<String, Filter> filterHashMap = new HashMap<>(INITIAL_CAPACITY);
        filterHashMap.put(AUTHC, kapcbLoginFilter);
        shiroFilterFactoryBean.setFilters(filterHashMap);
        Map<String, String> filterChainMap = new LinkedHashMap<>();
        filterChainMap.put("/index.jsp", ANON);
        filterChainMap.put(LOGIN_URL, ANON);
        filterChainMap.put(LOGOUT_URL, ANON);
        filterChainMap.put(USER_INFO_URL, AUTHC);
        filterChainMap.put(UN_LOGIN_URL, ANON);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 配置 ModularRealmAuthenticator
     *
     * @return ModularRealmAuthenticator
     */
    @Bean
    public ModularRealmAuthenticator authenticator() {
        ModularRealmAuthenticator modularRealmAuthenticator = new ModularRealmAuthenticator();
        FirstSuccessfulStrategy firstSuccessfulStrategy = new FirstSuccessfulStrategy();
        modularRealmAuthenticator.setAuthenticationStrategy(firstSuccessfulStrategy);
        return modularRealmAuthenticator;
    }

    /**
     * 禁用Session
     *
     * @return SessionStorageEvaluator
     */
    @Bean
    protected SessionStorageEvaluator sessionStorageEvaluator() {
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        return defaultSessionStorageEvaluator;
    }

}

package com.kapcb.ccc.common.config;

import com.kapcb.ccc.common.jwt.JwtFilter;
import com.kapcb.ccc.common.shiro.JwtCredentialsMatchers;
import com.kapcb.ccc.common.filter.KapcbLoginFilter;
import com.kapcb.ccc.common.shiro.JwtRealm;
import com.kapcb.ccc.common.shiro.UserRealm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
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
import java.util.HashMap;
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
    private static final String LOGIN_URL = "/kapcb/shiro/login";
    private static final String LOGOUT_URL = "/kapcb/shiro/logout";
    private static final String USER_INFO_URL = "/kapcb/shiro/getUserInfo";
    private static final String UN_LOGIN_URL = "/kapcb/shiro/**";
    private static final String LOGIN_PAGE_URL = "/kapcb/shiro/page";
    private static final String UN_AUTHOR_URL = "/kapcb/shiro/";
    private static final String LOGIN_SUCCESS_URL = "/kapcb/shiro/see";

    private final KapcbLoginFilter kapcbLoginFilter;

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
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
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

    public JwtFilter jwtFilter() {
        return new JwtFilter();
    }


    /**
     * 配置访问资源需要的权限
     *
     * @param securityManager SecurityManager
     * @return ShiroFilterFactoryBean
     */
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
        /**
         * 设置多 Realm的认证策略，默认 AtLeastOneSuccessfulStrategy
         */
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

    /**
     * JwtRealm 配置，需实现 Realm 接口
     *
     * @return JwtRealm
     */
    @Bean
    public JwtRealm jwtRealm() {
        JwtRealm jwtRealm = new JwtRealm();
        /**
         * 设置加密算法
         */
        CredentialsMatcher credentialsMatcher = new JwtCredentialsMatchers();
        /**
         * 设置加密次数
         */
        jwtRealm.setCredentialsMatcher(credentialsMatcher);
        return jwtRealm;

    }

    /**
     * UserRealm 配置，需实现 Realm 接口
     *
     * @return UserRealm
     */
    @Bean
    public UserRealm userRealm() {
        UserRealm userRealm = new UserRealm();
        /**
         * 设置加密算法
         */
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher("SHA-1");

        /**
         * 设置加密次数
         */
        hashedCredentialsMatcher.setHashIterations(16);
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return userRealm;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        /**
         * Authenticator
         */
        securityManager.setAuthenticator(authenticator());

        /**
         * Realm
         */
        List<Realm> realms = new ArrayList<>(16);
        realms.add(jwtRealm());
        realms.add(userRealm());
        securityManager.setRealms(realms);

        /**
         * 关闭 Shiro 自带的 Session
         */
        DefaultSubjectDAO defaultSubjectDAO = new DefaultSubjectDAO();
        defaultSubjectDAO.setSessionStorageEvaluator(sessionStorageEvaluator());
        return securityManager;
    }
}

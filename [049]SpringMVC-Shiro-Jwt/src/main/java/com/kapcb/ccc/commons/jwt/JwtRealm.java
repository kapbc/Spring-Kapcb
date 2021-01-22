package com.kapcb.ccc.commons.jwt;

import com.kapcb.ccc.commons.domain.User;
import com.kapcb.ccc.service.IPermissionService;
import com.kapcb.ccc.service.IRoleService;
import com.kapcb.ccc.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Set;

/**
 * <a>Title: JwtRealm </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/22-11:21
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class JwtRealm extends AuthorizingRealm {

    private final IUserService userService;
    private final IRoleService roleService;
    private final IPermissionService permissionService;

    @PostConstruct
    public void initConfig() {
        setCredentialsMatcher(jwtCredentialsMatchers());
    }

    @Bean
    public JwtCredentialsMatchers jwtCredentialsMatchers() {
        return new JwtCredentialsMatchers();
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = principalCollection.getPrimaryPrincipal().toString();
        log.info("the current use's username is : " + username);
        Set<String> roleSet = roleService.getRoleByUsername(username);
        Set<String> permissionSet = permissionService.getPermissionByUsername(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roleSet);
        simpleAuthorizationInfo.setStringPermissions(permissionSet);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = authenticationToken.getPrincipal().toString();
        log.info("the username in jwt realm is : " + username);
        User user = userService.getUserInfoByUsername(username);
        if (!StringUtils.equals(username, user.getUsername())) {
            log.error("the account of " + username + "is not exist in system");
            throw new UnknownAccountException("the account of " + username + "is not exist in system");
        }
        if (StringUtils.equals("Y", user.getStatus())) {
            log.error("the account of " + username + " is locked");
            throw new LockedAccountException("the account of " + username + " is locked");
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }
}

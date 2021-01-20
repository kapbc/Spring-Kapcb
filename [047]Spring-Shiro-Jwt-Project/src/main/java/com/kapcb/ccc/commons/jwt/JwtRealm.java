package com.kapcb.ccc.commons.jwt;

import com.kapcb.ccc.commons.constants.Constant;
import com.kapcb.ccc.commons.domain.User;
import com.kapcb.ccc.service.IPermissionService;
import com.kapcb.ccc.service.IRoleService;
import com.kapcb.ccc.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;

/**
 * <a>Title: JwtRealm </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/20-15:04
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class JwtRealm extends AuthorizingRealm {

    private final IUserService userService;
    private final IRoleService roleService;
    private final IPermissionService permissionService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = principalCollection.getPrimaryPrincipal().toString();
        log.warn("the username is : " + username);
        Set<String> roles = roleService.getRolesByUsername(username);
        Set<String> permissions = permissionService.getPermissionByUsername(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = authenticationToken.getPrincipal().toString();
        log.warn("the username of jwtRealm is : " + username);
        User user = userService.getUserByUsername(username);
        if (Objects.equals(null, user.getUsername())) {
            log.error("the account is not exist");
            throw new IncorrectCredentialsException("Username or password error, the user of username : " + username + " is not exist");
        }
        if (Objects.equals(Constant.Y.getString(), user.getStatus())) {
            log.error("the account is locked");
            throw new LockedAccountException("The username of : " + username + "'s account is locked");
        }
        ByteSource encryptSalt = ByteSource.Util.bytes(username);
        log.warn("the encryptSalt is : " + encryptSalt);
        return new SimpleAuthenticationInfo(user, user.getPassword(), encryptSalt, getName());
    }
}

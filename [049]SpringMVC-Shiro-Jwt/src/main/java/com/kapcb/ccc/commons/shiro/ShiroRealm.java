package com.kapcb.ccc.commons.shiro;

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
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Set;

/**
 * <a>Title: ShiroRealm </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/21 22:54
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ShiroRealm extends AuthorizingRealm {

    private final IUserService userService;
    private final IRoleService roleService;
    private final IPermissionService permissionService;

    @PostConstruct
    public void initJndi() {
        setCachingEnabled(true);
    }

    /**
     * only support for UsernmaePasswordToken
     *
     * @param token AuthenticationToken
     * @return boolean
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = principalCollection.getPrimaryPrincipal().toString();
        log.info("the username is : " + username);
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
        log.info("the username in shiro realm is : " + username);
        User user = userService.getUserInfoByUsername(username);
        log.info("current user of username: " + username + " is : " + user);
        if (!StringUtils.equals(username, user.getUsername())) {
            log.error("the username of " + username + " is not exist in sysytem");
            throw new UnknownAccountException("username of " + username + " is not exist in sysytem");
        }
        if (StringUtils.equalsIgnoreCase("Y", user.getStatus())) {
            log.error("the account of " + username + "'s is locked");
            throw new LockedAccountException("the account is locked");
        }
        ByteSource passwordEncryptSalt = ByteSource.Util.bytes(username);
        log.info("the password encrypt salt is : " + passwordEncryptSalt);
        return new SimpleAuthenticationInfo(user, user.getPassword(), passwordEncryptSalt, getName());
    }
}

package com.kapcb.ccc.common.shiro;

import com.kapcb.ccc.common.jwt.JwtToken;
import com.kapcb.ccc.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AccountException;
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
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;

/**
 * <a>Title: JwtRealm </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/13 22:51
 */
@Slf4j
@Component
public class JwtRealm extends AuthorizingRealm {

    /**
     * 限定这个 Realm 只处理定义的 JwtToken
     *
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.getPrimaryPrincipal();
        if (Objects.equals(null, user)) {
            throw new UnknownAccountException("user is not login");
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roles = ShiroRealm.roleMap.get(user.getUsername());
        Set<String> permissions = ShiroRealm.permissionMap.get(user.getUsername());
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    /**
     * 此处的 SimpleAuthenticationInfo 可返回任意值，密码校验时不会用到它
     *
     * @param authenticationToken AuthenticationToken
     * @return AuthenticationInfo
     * @throws AuthenticationException AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        JwtToken jwtToken = (JwtToken) authenticationToken;
        if (Objects.equals(jwtToken.getPrincipal(), null)) {
            throw new AccountException("Jwt token arguments exception");
        }

        /**
         * 从 JwtToken中获取当前用户
         */
        String username = jwtToken.getPrincipal().toString();
        User user = ShiroRealm.userMap.get(username);
        if (Objects.equals(null, user)) {
            throw new UnknownAccountException("Account is not exist");
        }
        if (StringUtils.equals("Y", user.getStatus())) {
            throw new LockedAccountException("The account is locked, login reject");
        }
        return new SimpleAuthenticationInfo(user, username, getName());
    }
}

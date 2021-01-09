package com.kapcb.ccc.realm;

import com.kapcb.ccc.common.exception.UserNotExistException;
import com.kapcb.ccc.common.exception.UserUnLoginException;
import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

/**
 * <a>Title: UserRealm </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/9 12:21
 */
@Slf4j
@RequiredArgsConstructor
public class UserRealm extends AuthorizingRealm {

    private final UserService userService;

    /**
     * Shiro角色权限验证，会调用doGetAuthorizationInfo方法，通过SimpleAuthorizationInfo.setRoles()方法设置用户角色，
     * 通过SimpleAuthorizationInfo.setStringPermissions()设置用户权限，这里暂时给个空集合，在项目中，用户的角色权限需
     * 要从数据库中查询
     *
     * @param principals PrincipalCollection
     * @return AuthorizationInfo
     */
    @SneakyThrows
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String primaryPrincipal = (String) principals.getPrimaryPrincipal();
        if (StringUtils.isBlank(primaryPrincipal)) {
            throw new UserUnLoginException("User Un Login");
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roles = new HashSet<>();
        Set<String> permissions = new HashSet<>();
        /**
         * 角色:权限
         */
        roles.add("USER");
        permissions.add("USER:ADD");

        /**
         * 角色可以通过数据库查询得到
         * 权限可以通过数据库查询得到
         */
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    /**
     * Shiro进行身份验证时，会调用到doGetAuthenticationInfo方法，在方法内部，通过UsernamePasswordToken 获得用户传过来的用户名，
     * 再通过userService.getUserByUsername方法从数据库中查询用户信息，如果用户为空，说账号不存在，否则将查询出来的用户名及密码，封
     * 装到SimpleAuthenticationInfo 对象中，并返回，用于接下来的密码验证
     *
     * @param token AuthenticationToken
     * @return AuthenticationInfo
     * @throws AuthenticationException AuthenticationException
     */
    @SneakyThrows
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        User user = userService.getUserByUsername(username);
        if (StringUtils.isBlank(user.getUserName())) {
            throw new UserNotExistException("User Not Exist");
        }
        return new SimpleAuthenticationInfo(user.getUserName(), user.getPassWord().toCharArray(), getName());
    }
}

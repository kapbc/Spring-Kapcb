package com.kapcb.ccc.common.shiro;

import com.kapcb.ccc.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
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
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * <a>Title: ShiroRealm </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 * <p>
 * 同时开启身份验证和权限验证，需要继承 AuthorizingRealm
 * 并实现其  doGetAuthenticationInfo()和 doGetAuthorizationInfo 两个方法
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/16 10:16
 */
@Slf4j
@Component
@SuppressWarnings("serial")
public class ShiroRealm extends AuthorizingRealm {

    public static Map<String, User> userMap = new HashMap<>(16);
    public static Map<String, Set<String>> roleMap = new HashMap<>(16);
    public static Map<String, Set<String>> permissionMap = new HashMap<>(16);

    static {
        User kapcb = new User(1L, "kapcb", "ccc", "123456", "eircccallroot@163.com", LocalDateTime.now(), 18, "N");
        User ccc = new User(2L, "eric", "1234", "123456", "eircccallroot@126.com", LocalDateTime.now(), 18, "N");

        userMap.put("kapcb", kapcb);
        userMap.put("ccc", ccc);

        roleMap.put("kapcb", new HashSet<String>() {
            {
                add("admin");
            }
        });

        roleMap.put("ccc", new HashSet<String>() {
            {
                add("guest");
            }
        });

        permissionMap.put("pulm", new HashSet<String>() {
            {
                add("article:read");
            }
        });
    }

    /**
     * 限定这个 Realm 只处理 UsernamePasswordToken
     *
     * @param token AuthenticationToken
     * @return boolean
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }


    /**
     * 询数据库，将获取到的用户的角色及权限信息返回
     *
     * @param principalCollection PrincipalCollection
     * @return AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        /**
         * 获取当前用户
         */
        Subject subject = SecurityUtils.getSubject();

        /**
         * User currentUser = (User) principalCollection.getPrimaryPrincipal();
         */
        User currentUser = (User) subject.getPrincipal();

        /**
         * 查询数据库，获取用户的角色信息
         */
        Set<String> roles = roleMap.get(currentUser.getUsername());
        /**
         * 查询数据库，获取用户的权限信息
         */
        Set<String> permissions = permissionMap.get(currentUser.getUsername());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    /**
     * 模拟查询数据库，将获取到的用户安全数据封装返回
     *
     * @param authenticationToken AuthenticationToken
     * @return AuthenticationInfo
     * @throws AuthenticationException AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        /**
         * 从 AuthenticationToken 中获取当前用户
         */
        String username = (String) authenticationToken.getPrincipal();
        /**
         * 查询数据库获取用户信息, 此处使用 userMap 来模拟查询数据库
         */
        User user = userMap.get(username);

        /**
         * 用户不存在
         */
        if (Objects.equals(null, user)) {
            throw new UnknownAccountException("The User Is Not Exist");
        }

        /**
         * 用户被锁定
         */
        if (StringUtils.equals("Y", user.getStatus())) {
            throw new LockedAccountException("The User Account Is Locked");
        }

        /**
         * 使用用户名作为盐值
         */
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);
        log.warn("the credentialsSalt is : " + credentialsSalt);

        /**
         * 将获取到的用户数据封装成 AuthenticationInfo 对象返回，此处封装为 SimpleAuthenticationInfo 对象。
         * 参数1. 认证的实体信息，可以是从数据库中获取到的用户实体类对象或者用户名
         * 参数2. 查询获取到的登录密码
         * 参数3. 盐值
         * 参数4. 当前 Realm 对象的名称，直接调用父类的 getName() 方法即可
         */
        return new SimpleAuthenticationInfo(user, user.getPassword(), credentialsSalt, getName());
    }
}

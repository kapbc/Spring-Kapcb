package com.kapcb.ccc.commons.jwt;

import com.kapcb.ccc.commons.constants.Constant;
import com.kapcb.ccc.commons.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.springframework.stereotype.Component;

/**
 * <a>Title: JwtCredentialsMatchers </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/20 22:05
 */
@Slf4j
@Component
public class JwtCredentialsMatchers implements CredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        String token = authenticationToken.getCredentials().toString();
        log.warn("the token of jwt credentials is : " + token);
        String username = authenticationToken.getPrincipal().toString();
        log.warn("the username of jwt credentials is : " + username);
        return JwtUtil.verified(token, username, Constant.JWT_AUTHORIZATION_HEARD.getString());
    }
}

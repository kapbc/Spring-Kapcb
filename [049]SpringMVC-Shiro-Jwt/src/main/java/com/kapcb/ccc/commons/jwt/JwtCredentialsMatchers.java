package com.kapcb.ccc.commons.jwt;

import com.kapcb.ccc.commons.constant.Constants;
import com.kapcb.ccc.commons.utils.jwt.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.springframework.stereotype.Component;

/**
 * <a>Title: JwtCredentialsMatchers </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/22-11:23
 */
@Slf4j
@Component
public class JwtCredentialsMatchers implements CredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        String token = authenticationToken.getCredentials().toString();
        String username = authenticationToken.getPrincipal().toString();
        return JwtUtil.verified(username, token, Constants.JWT_SECRET.getString());
    }
}

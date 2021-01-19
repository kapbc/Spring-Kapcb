package com.kapcb.ccc.common.shiro;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.kapcb.ccc.common.jwt.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.springframework.stereotype.Component;

/**
 * <a>Title: KapcbCredentialsMatchers </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/12 21:12
 */
@Slf4j
@Component
public class JwtCredentialsMatchers extends SimpleCredentialsMatcher {

    /**
     * JwtCredentialsMatcher只需验证JwtToken内容是否合法
     *
     * @param authenticationToken AuthenticationToken
     * @param authenticationInfo  AuthenticationInfo
     * @return boolean
     */
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        log.warn("process do credentials match");
        String token = authenticationToken.getPrincipal().toString();
        String username = authenticationInfo.getPrincipals().toString();
        try {
            Algorithm algorithm = Algorithm.HMAC256(JwtUtil.CONFIDENTIAL);
            JWTVerifier verifier = JWT.require(algorithm).withClaim("username", username).build();
            log.warn("the Jwt verifier is : " + verifier);
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            log.error("Jwt Verifier error, the exception is : " + e.getMessage());
        }
        return false;
    }
}

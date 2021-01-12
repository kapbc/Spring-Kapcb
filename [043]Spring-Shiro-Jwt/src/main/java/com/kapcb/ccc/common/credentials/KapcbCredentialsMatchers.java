package com.kapcb.ccc.common.credentials;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.util.SimpleByteSource;
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
public class KapcbCredentialsMatchers extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        log.warn("process do credentials match");
        SimpleByteSource simpleByteSourceFromToken = new SimpleByteSource((char[]) token.getCredentials());
        SimpleByteSource simpleByteSourceFromInfo = new SimpleByteSource((char[]) info.getCredentials());
        return equals(simpleByteSourceFromToken, simpleByteSourceFromInfo);
    }
}

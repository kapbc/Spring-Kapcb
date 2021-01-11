package com.kapcb.ccc.commons.credentials;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.springframework.stereotype.Component;

/**
 * <a>Title: KapcbLoginCredentialsMatcher </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/11 20:06
 */
@Slf4j
@Component
public class KapcbCredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        log.warn("process the do Credentials");
        ByteSource simpleByteSourceForToken = new SimpleByteSource((char[]) token.getCredentials());
        SimpleByteSource simpleByteSourceForDataBase = new SimpleByteSource((char[]) info.getCredentials());
        log.warn("the Credentials result is : " + equals(simpleByteSourceForToken, simpleByteSourceForDataBase));
        return equals(simpleByteSourceForToken, simpleByteSourceForDataBase);
    }
}

package com.kapcb.ccc.credentials;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.util.SimpleByteSource;

import java.util.Objects;

/**
 * <a>Title: KpacbCredentialsMatcher </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 * <p>
 * 自定义凭证(密码)匹配器
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/9 12:23
 */
@Slf4j
public class KpacbCredentialsMatcher extends SimpleCredentialsMatcher {

    /**
     * 此过滤器主要用于凭证(密码)匹配，即校验用户输入的密码和从数据库中查询的密码是否相同，相同则返回true，否则返回false，此匹配器继承了
     * SimpleCredentialsMatcher，并重写doCredentialsMatch方法，代码如下
     *
     * @param token AuthenticationToken
     * @param info  AuthenticationInfo
     * @return boolean
     */
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        // 对前台传入的明文数据加密，根据自定义加密规则加密
        SimpleByteSource simpleByteSourceFromFontDesk = new SimpleByteSource((char[]) token.getCredentials());

        // 从数据库获取的加密数据
        SimpleByteSource simpleByteSourceFromDataBase = new SimpleByteSource((char[]) info.getCredentials());

        log.warn("Login Count Compare Result is : " + Objects.equals(simpleByteSourceFromDataBase, simpleByteSourceFromFontDesk));
        // 返回对比结果
        return Objects.equals(simpleByteSourceFromDataBase, simpleByteSourceFromFontDesk);
    }
}

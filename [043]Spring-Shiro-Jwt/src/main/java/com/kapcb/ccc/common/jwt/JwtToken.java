package com.kapcb.ccc.common.jwt;

import com.kapcb.ccc.common.jwt.JwtUtil;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * <a>Title: JwtToken </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/13 22:53
 */
public class JwtToken implements AuthenticationToken {

    private static final long serialVersionUID = 6290758499491708910L;

    /**
     * 加密之后的 token 串
     */
    private String token;
    private String username;

    public JwtToken(String token) {
        this.token = token;
        this.username = JwtUtil.getClaimFiled(token, "username");
    }

    @Override
    public Object getPrincipal() {
        return this.username;
    }

    @Override
    public Object getCredentials() {
        return this.token;
    }
}

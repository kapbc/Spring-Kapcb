package com.kapcb.ccc.commons.jwt;

import com.kapcb.ccc.commons.utils.jwt.JwtUtil;
import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * <a>Title: JwtToken </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/21 22:54
 */
@Data
public class JwtToken implements AuthenticationToken {

    private static final long serialVersionUID = 1187327171772380316L;

    private String username;
    private String token;

    public JwtToken(String token) {
        this.token = token;
        this.username = JwtUtil.getClaim(token, "username");
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

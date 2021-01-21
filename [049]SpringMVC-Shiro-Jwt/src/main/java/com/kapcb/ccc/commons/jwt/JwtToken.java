package com.kapcb.ccc.commons.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@AllArgsConstructor
public class JwtToken implements AuthenticationToken {

    private static final long serialVersionUID = 1187327171772380316L;

    private String username;
    private String token;

    public JwtToken(String token) {
        this.token = token;
        this.username =
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

package com.kapcb.ccc.commons.jwt;

import com.kapcb.ccc.commons.constants.Constant;
import com.kapcb.ccc.commons.utils.JwtUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * <a>Title: JwtToken </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/20-14:17
 */
@Slf4j
@Data
@SuppressWarnings("serial")
public class JwtToken implements AuthenticationToken {

    private String token;
    private String username;

    public JwtToken(String token) {
        this.token = token;
        this.username = JwtUtil.getClaimFiled(token, Constant.JWT_USERNAME.getString());
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

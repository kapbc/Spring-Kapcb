package com.kapcb.ccc.commons.jwt;

import lombok.extern.slf4j.Slf4j;

/**
 * <a>Title: JwtUtil </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/17 20:56
 */
@Slf4j
public class JwtUtil {

    private JwtUtil() {
    }

    /**
     * token加密时使用的密钥
     * 一旦得到该密钥也就可以伪造token了
     */
    public static final String KEY = "kapcb";

    /**
     * 过期时间
     */
    public static final long EXPIRE_TIME = 5 * 6 * 60;

}

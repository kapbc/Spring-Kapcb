package com.kapcb.ccc.common.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * <a>Title: JwtUtil </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/13 21:15
 */
@Slf4j
@Component
public class JwtUtil {

    /**
     * 过期时间5分钟
     */
    private static final long EXPIRE_TIME = 5 * 60 * 1000;
    /**
     * 密钥
     */
    public static final String CONFIDENTIAL = "kapcb";
    /**
     * 请求头
     */
    public static final String AUTH_HEADER = "X-Authorization-With";

    /**
     * 验证token是否正确
     *
     * @param token        String
     * @param username     String
     * @param confidential String
     * @return boolean
     */
    public static boolean verified(String token, String username, String confidential) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(confidential);
            JWTVerifier verifierUsername = JWT.require(algorithm).withClaim("username", username).build();
            verifierUsername.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            log.error("Jwt token verified error, the exception is : " + e.getMessage());
            return false;
        }
    }

    /**
     * 获得 token 中的自定义信息, 无需confidential密钥解密也能获得
     *
     * @param token String
     * @param filed String
     * @return String
     */
    public static String getClaimFiled(String token, String filed) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(filed).asString();
        } catch (JWTDecodeException e) {
            log.error("Jwt fet info from token error, the exception is : " + e.getMessage());
            return null;
        }
    }

    /**
     * 生成签名
     *
     * @param username     String
     * @param confidential String
     * @return String
     */
    public static String sign(String username, String confidential) {
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(confidential);
            // 附带username, nickname 信息
            return JWT.create().withClaim("username", username).withExpiresAt(date).sign(algorithm);
        } catch (JWTCreationException e) {
            log.error("Jwt creat error, the exception is : " + e.getMessage());
            return null;
        }
    }

    /**
     * 获取token的签发时间
     *
     * @param token String token
     * @return Date
     */
    public static Date getIssuedAt(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getIssuedAt();
        } catch (JWTDecodeException e) {
            log.error("Jwt decode error, the exception is : " + e.getMessage());
            return null;
        }
    }

    /**
     * 验证token是否过期
     *
     * @param token String
     * @return boolean
     */
    public static boolean isTokenExpired(String token) {
        Date now = Calendar.getInstance().getTime();
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getIssuedAt().before(now);
    }

    /**
     * 刷新token的过期时间
     *
     * @param token        String
     * @param confidential String
     * @return String
     */
    public static String refreshTokenExpireTime(String token, String confidential) {
        DecodedJWT jwt = JWT.decode(token);
        Map<String, Claim> claims = jwt.getClaims();
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(confidential);
            Builder builder = JWT.create().withExpiresAt(date);
            for (Map.Entry<String, Claim> entry : claims.entrySet()) {
                builder.withClaim(entry.getKey(), entry.getValue().asString());
            }
            return builder.sign(algorithm);
        } catch (JWTCreationException e) {
            log.error("Jwt create error, the exception is : " + e.getMessage());
            return null;
        }
    }

    /**
     * 生成16为随机盐值
     *
     * @return String
     */
    public static String generateSalt() {
        SecureRandomNumberGenerator secureRandomNumberGenerator = new SecureRandomNumberGenerator();
        String salt = secureRandomNumberGenerator.nextBytes(16).toHex();
        log.warn("the generator salt is : " + salt);
        return salt;
    }
}

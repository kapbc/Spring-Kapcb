package com.kapcb.ccc.commons.utils.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * <a>Title: JwtUtil </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/22-8:37
 */
@Slf4j
public class JwtUtil {

    /**
     * token expire time
     */
    private static final int EXPIRE_TIME = 5 * 60 * 1000;

    private JwtUtil() {
    }

    /**
     * sign the jwt token
     *
     * @param username String
     * @param secret   String
     * @return String
     */
    @SneakyThrows(JWTCreationException.class)
    public static String sign(String username, String secret) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        log.info("the expire time is : " + expireDate);
        String token = JWT.create().withClaim("usernam", username).withExpiresAt(expireDate).sign(algorithm);
        log.warn("the token is : " + token);
        return token;
    }

    /**
     * verification the jwt token
     *
     * @param username String
     * @param token    String
     * @param secret   String
     * @return boolean
     */
    @SneakyThrows(value = {JWTVerificationException.class, JWTDecodeException.class})
    public static boolean verified(String username, String token, String secret) {
        DecodedJWT jwt = JWT.decode(token);
        Algorithm algorithm = Algorithm.HMAC256(secret);
        JWTVerifier jwtVerifier = JWT.require(algorithm).withClaim("username", username).build();
        jwtVerifier.verify(jwt);
        return true;
    }

    /**
     * get the claim of the field in jwt token
     *
     * @param token String
     * @param field String
     * @return String
     */
    @SneakyThrows(JWTDecodeException.class)
    public static String getClaim(String token, String field) {
        DecodedJWT jwt = JWT.decode(token);
        String claim = jwt.getClaim(field).asString();
        log.info("the field of : " + field + " is : " + claim);
        return claim;
    }

    /**
     * refresh the expire jwt token
     *
     * @param token  String
     * @param secret String
     * @return String
     */
    @SneakyThrows(value = {JWTDecodeException.class, JWTCreationException.class})
    public static String refreshExpireTimeToken(String token, String secret) {
        DecodedJWT jwt = JWT.decode(token);
        Map<String, Claim> claims = jwt.getClaims();
        Algorithm algorithm = Algorithm.HMAC256(secret);
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        log.info("the refresh expire time token's new expire time is : " + expireDate);
        Builder builder = JWT.create().withExpiresAt(expireDate);
        claims.forEach((k, v) -> {
            builder.withClaim(k, v.asString());
        });
        String newRefreshToken = builder.sign(algorithm);
        log.info("new refresh token is : " + newRefreshToken);
        return newRefreshToken;
    }

    /**
     * wheather the jwt token is expired
     *
     * @param token String
     * @return boolean
     */
    @SneakyThrows(JWTDecodeException.class)
    public static boolean isTokenExpired(String token) {
        Date currentTime = Calendar.getInstance().getTime();
        DecodedJWT jwt = JWT.decode(token);
        boolean before = jwt.getIssuedAt().before(currentTime);
        log.warn("the token expire time whether before current time result is : " + before);
        return before;
    }

    /**
     * get the jwt token expire time
     *
     * @param token String
     * @return Date
     */
    @SneakyThrows({JWTDecodeException.class})
    public static Date getTokenExpireTime(String token) {
        DecodedJWT jwt = JWT.decode(token);
        Date issuedAt = jwt.getIssuedAt();
        log.info("the token expire time is : " + issuedAt);
        return issuedAt;
    }

    /**
     * get jwt generator sixteen hex password encrypt salt
     *
     * @return String
     */
    public static String generateSalt() {
        SecureRandomNumberGenerator secureRandomNumberGenerator = new SecureRandomNumberGenerator();
        String salt = secureRandomNumberGenerator.nextBytes(16).toHex();
        log.info("the jwtutil generate password encrypt salt is : " + salt);
        return salt;
    }
}

package com.kapcb.ccc.commons.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.kapcb.ccc.commons.constants.Constant;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * <a>Title: JwtUtil </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/20-13:44
 */
@Slf4j
public class JwtUtil {

    private static final int EXPIRE_TIME = 5 * 60 * 1000;

    private JwtUtil() {
    }

    /**
     * sign the new token
     *
     * @param username String
     * @param secret   String
     * @return String
     */
    public static String sign(String username, String secret) {
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create().withClaim(Constant.JWT_USERNAME.getString(), username).withExpiresAt(date).sign(algorithm);
            log.warn("the sign token is : " + token);
            return token;
        } catch (JWTCreationException e) {
            log.error("Jwt create error, the exception is : " + e.getMessage());
            return null;
        }
    }

    /**
     * verified the token whether is right
     *
     * @param token    String
     * @param username String
     * @param secret   String
     * @return boolean
     */
    public static boolean verified(String token, String username, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier jwtVerifier = JWT.require(algorithm).withClaim(Constant.JWT_USERNAME.getString(), username).build();
            log.warn("JWTVerifier is : " + jwtVerifier.toString());
            jwtVerifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            log.error("Jwt verification error, the exception is : " + e.getMessage());
            return false;
        }
    }

    /**
     * refresh the expire time token
     *
     * @param token  String
     * @param secret String
     * @return String
     */
    public static String refreshExpireTimeToken(String token, String secret) {
        DecodedJWT decode = JWT.decode(token);
        Map<String, Claim> claims = decode.getClaims();
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            Builder builder = JWT.create().withExpiresAt(date);
            claims.forEach((k, v) -> {
                builder.withClaim(k, v.asString());
            });
            String sign = builder.sign(algorithm);
            log.warn("the refresh expire time token is : " + sign);
            return sign;
        } catch (JWTCreationException e) {
            log.error("Jwt refresh expire time token error, the exception is : " + e.getMessage());
            return null;
        }
    }

    /**
     * get the information of filed in token
     *
     * @param token String
     * @param filed String
     * @return String
     */
    public static String getClaimFiled(String token, String filed) {
        try {
            DecodedJWT decode = JWT.decode(token);
            Claim claim = decode.getClaim(filed);
            log.warn("the claim of '" + filed + "' is : " + claim.asString());
            return claim.asString();
        } catch (JWTDecodeException e) {
            log.error("Jwt decode error, the exception is : " + e.getMessage());
            return null;
        }
    }

    /**
     * whether the token is expired
     *
     * @param token String
     * @return boolean
     */
    private static boolean isTokenExpired(String token) {
        try {
            Date time = Calendar.getInstance(Locale.CHINA).getTime();
            DecodedJWT jwt = JWT.decode(token);
            log.warn("the token expire time is : " + jwt.getIssuedAt().toString());
            return jwt.getIssuedAt().before(time);
        } catch (JWTDecodeException e) {
            log.error("Jwt decode error, the exception is : " + e.getMessage());
            return false;
        }
    }


    /**
     * get the token expire time
     *
     * @param token String
     * @return Date
     */
    private static Date getIssuedAt(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            Date issuedAt = jwt.getIssuedAt();
            log.warn("the issued of the token is : " + issuedAt);
            return issuedAt;
        } catch (JWTDecodeException e) {
            log.error("Jwt decode error, the exception is : " + e.getMessage());
            return null;
        }
    }

    /**
     * get the generate salt
     *
     * @return String
     */
    private static String generateSalt() {
        SecureRandomNumberGenerator secureRandomNumberGenerator = new SecureRandomNumberGenerator();
        String salt = secureRandomNumberGenerator.nextBytes(16).toHex();
        log.warn("the generate salt is : " + salt);
        return salt;
    }
}

package com.kapcb.ccc.commons.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

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


    /**
     * JWT由3个部分组成,分别是 头部Header,载荷Payload一般是用户信息和声明,签证Signature一般是密钥和签名
     * 当头部用base64进行编码后一般都会呈现eyJ...形式,而载荷为非强制使用,签证则包含了哈希算法加密后的数据,包括转码后的header,payload和sercetKey
     * 而payload又包含几个部分,issuer签发者,subject面向用户,iat签发时间,exp过期时间,aud接收方。
     *
     * @param id      String
     * @param issuer  String
     * @param subject String
     * @return String
     */
    public static String getToken(String id, String issuer, String subject) {
        // 使用Hash256算法进行加密
        SignatureAlgorithm hs256 = SignatureAlgorithm.HS256;
        // 获取当前时间, 用于计算token过期时间
        long systemTime = System.currentTimeMillis();
        Date now = new Date(systemTime);
        // 将密钥转换为base64, 在将其转换为字节码
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(KEY);

        // 对其使用Hash256进行加密
        Key secretKeySpec = new SecretKeySpec(apiKeySecretBytes, hs256.getJcaName());
        //JWT生成类,此时设置iat,以及根据传入的id设置token
        JwtBuilder jwtBuilder = Jwts.builder().setId(id).setIssuedAt(now);
        if (subject != null) {
            jwtBuilder.setSubject(subject);
        }
        if (issuer != null) {
            jwtBuilder.setIssuer(issuer);
        }
        // 由于Payload是非必须加入的,所以这时候要加入检测
        jwtBuilder.signWith(hs256, secretKeySpec);

        // 生成 Signature
        if (EXPIRE_TIME >= 0) {
            Date date = new Date(EXPIRE_TIME + systemTime);
            jwtBuilder.setExpiration(date);
        }
        return jwtBuilder.compact();
    }

    /**
     * 跟新token的过期时间, 以及签发者, 面向用户, 生成新的token签发返回
     *
     * @param token String
     * @return String
     */
    public static String updateToken(String token) {
        // Claims就是包含了我们的Payload信息类
        Claims claims = verifyToken(token);
        String id = claims.getId();
        /**
         * 面向用户
         */
        String subject = claims.getSubject();
        /**
         * 签发者
         */
        String issuer = claims.getIssuer();
        return getToken(id, subject, issuer);
    }

    /**
     * 将token解密出来,将payload信息包装成Claims类返回
     *
     * @param token String
     * @return Claims
     */
    public static Claims verifyToken(String token) {
        return Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(KEY)).parseClaimsJws(token).getBody();
    }
}

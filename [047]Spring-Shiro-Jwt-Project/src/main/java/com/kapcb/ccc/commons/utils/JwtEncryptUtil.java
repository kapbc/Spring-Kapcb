package com.kapcb.ccc.commons.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * <a>Title: JwtPasswordEncrpyUtil </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/20-15:05
 */
@Slf4j
public class JwtEncryptUtil {

    /**
     * 自动生成的盐值长度
     */
    private static final int PWD_SALT_LENGTH = 6;
    /**
     * 散列次数
     */
    private static final int PWD_HASH_ITERATIONS = 16;
    /**
     * 加密算法
     */
    private static final String PWD_ALGORITHM_NAME = "SHA-1";

    private JwtEncryptUtil() {
    }

    private static String generateSalt() {
        String salt = RandomStringUtils.randomAlphabetic(PWD_SALT_LENGTH);
        log.warn("the generate salt is : " + salt);
        return salt;
    }

    public static String passwordEncrypt(String password, Object salt) {
        String encrypt = new SimpleHash(PWD_ALGORITHM_NAME, password, salt, PWD_HASH_ITERATIONS).toString();
        log.warn("the encrypt password is : " + encrypt);
        return encrypt;
    }

    public static void main(String[] args) {
        String password = "eirc";
        String encryptSalt = ByteSource.Util.bytes(password).toString();

        String encryptPassword = passwordEncrypt(password, encryptSalt);
        System.out.println("encryptPassword = " + encryptPassword);
    }

}

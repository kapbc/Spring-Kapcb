package com.kapcb.ccc.commons.utils.jwt;

import com.kapcb.ccc.commons.constant.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * <a>Title: PasswrodEncryptUtil </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/22-15:19
 */
@Slf4j
public class PasswordEncryptUtil {

    private PasswordEncryptUtil() {
    }

    public static String generateSaltEncrypt(String password) {
        String encryptPassword = new SimpleHash(Constants.SHIRO_REALM_ALGORITHM.getString(), password, generateSalt(), Constants.SIXTEEN.getInt()).toHex();
        log.info("the encrypt password is : " + encryptPassword);
        return encryptPassword;
    }

    public static String encrypt(String password, Object salt) {
        String encryptPassword = new SimpleHash(Constants.SHIRO_REALM_ALGORITHM.getString(), password, salt, Constants.SIXTEEN.getInt()).toHex();
        log.info("the encrypt password is : " + encryptPassword);
        return encryptPassword;
    }

    public static String generateSalt() {
        String salt = RandomStringUtils.randomAlphanumeric(Constants.SIXTEEN.getInt());
        log.info("the generate salt is : " + salt);
        return salt;
    }

    public static String generateSalt(int len) {
        String salt = RandomStringUtils.randomAlphanumeric(len);
        log.info("the generate salt is : " + salt);
        return salt;
    }

//    public static void main(String[] args) {
//        String password = "ddd";
//        ByteSource bytes = ByteSource.Util.bytes(password);
//        String encrypt = encrypt(password, bytes);
//        System.out.println("encrypt = " + encrypt);
//    }
}

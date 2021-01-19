package com.kapcb.ccc.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * <a>Title: ShiroPasswordUtil </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/19 22:05
 */
@Slf4j
public class ShiroPasswordUtil {

    /**
     * 自动生成盐值的长度
     */
    private static final int PWD_SALT_LENGTH = 6;

    /**
     * 密码散列的次数
     */
    private static final int PWD_HASH_ITERATIONS = 16;

    /**
     * 密码加密算法
     */
    private static final String PWD_ALGORITHM_NAME = "SHA-1";

    public ShiroPasswordUtil() {

    }

    /**
     * generate the encrypt password
     *
     * @param password String
     * @param salt     Object
     * @return String
     */
    public static String passwordEncrypt(String password, Object salt) {
        String newPassword = new SimpleHash(PWD_ALGORITHM_NAME, password, salt, PWD_HASH_ITERATIONS).toString();
        log.warn("new password is : " + newPassword);
        return newPassword;
    }

    public static String passwordGenerateEncrypt(String password) {
        String newPassword = new SimpleHash(PWD_ALGORITHM_NAME, password, generateSalt(), PWD_HASH_ITERATIONS).toString();
        log.warn("new password is : " + newPassword);
        return newPassword;
    }

    /**
     * 生成盐
     *
     * @return String
     */
    private static String generateSalt() {
        String salt = RandomStringUtils.randomAlphanumeric(PWD_SALT_LENGTH);
        log.warn("the generate salt is : " + salt);
        return salt;
    }

    public static void main(String[] args) {
        ByteSource kapcb = ByteSource.Util.bytes("kapcb");
        String s = ShiroPasswordUtil.passwordEncrypt("123456", kapcb);
        System.out.println("s = " + s);
        System.out.println(s.equals("1aa6a09b31689ae5f1cb3203a6abc68176336861"));
    }
}

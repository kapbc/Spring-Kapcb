package com.kapcb.ccc.tdd;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * <a>Title: PasswordTest </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/19 21:59
 */
public class PasswordTest {

    public static void main(String[] args) {
        ByteSource kapcb = ByteSource.Util.bytes("kapcb");
        SimpleHash simpleHash = new SimpleHash("SHA-1", "123456", kapcb, 16);
        System.out.println("simpleHash.toString() = " + simpleHash.toString());

    }
}

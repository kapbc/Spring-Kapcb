package com.kapcb.ccc.commons.constant;

/**
 * <a>Title: Constants </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/22-14:02
 */
public enum Constants {

    /**
     * JWT CONFIGURATION CONSTANTS
     */
    JWT_USERNAME("username", "constant of the jwt claim"),
    JWT_AUTHORIZATION_HEARD("X-Authorization-With", "the key of the jwt heard"),
    JWT_SECRET("kapcb", "the secret key of the jwt"),
    HTTP_RESPONSE_CONTENT_TYPE("application/json; charset = UTF-8", "http response content type"),

    /**
     * SHIRO CONFIGURATION CONSTANTS
     */
    SHIRO_REALM_ALGORITHM("SHA-1", "the shiro encrypt algorithm"),

    /**
     * SYSTEM RESPONSE STATUS CODE
     */
    FOUR_ZERO_ONE(401, "the response status code 401"),
    FOUR_ZERO_ZEO(400, "the response status code 400"),

    /**
     * SYSTEM CHARACTER CONSTANTS
     */
    Y("Y", "user account is locked flag"),

    /**
     * SYSTEM NUMBER CONSTANTS
     */
    SIXTEEN(16, "constant of 16");

    private String stringCode;
    private int intCode;
    private String description;

    Constants(String stringCode, String description) {
        this.stringCode = stringCode;
        this.description = description;
    }

    Constants(int intCode, String description) {
        this.intCode = intCode;
        this.description = description;
    }

    public String getString() {
        return this.stringCode;
    }

    public int getInt() {
        return this.intCode;
    }
}

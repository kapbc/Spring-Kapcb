package com.kapcb.ccc.commons.constants;

/**
 * <a>Title: Constant </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/20-14:20
 */
public enum Constant {

    /**
     * jwt constants
     */
    JWT_USERNAME("username", "constant of the jwt claim"),
    JWT_AUTHORIZATION_HEARD("X-Authorization-With", "the key of the jwt heard"),
    JWT_SECRET("kapcb", "the secret key of the jwt"),
    HTTP_RESPONSE_CONTENT_TYPE("application/json; charset = UTF-8", "http response content type"),

    SIXTEEN(16, "constant of 16");

    private String stringCode;
    private int intCode;
    private String description;

    Constant(String stringCode, String description) {
        this.stringCode = stringCode;
        this.description = description;
    }

    Constant(int intCode, String description) {
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

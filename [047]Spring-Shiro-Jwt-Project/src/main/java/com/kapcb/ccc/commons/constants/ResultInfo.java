package com.kapcb.ccc.commons.constants;

/**
 * <a>Title: ResultInfo </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/21-8:46
 */
public enum ResultInfo {


    /**
     * json result api constants
     */
    SUCCESS("success", "200"),
    FAIL("fail", "402"),
    LOGIN_SUCCESS("login success", "201"),
    LOGIN_FAIL("login fail", "202"),
    LOGIN_ERROR("login error", "203"),
    LOGIN_EXCEPTION("login exception", "204"),
    LOGIN_ACCOUNT_ERROR("username or password error", "205"),
    LOGIN_ACCOUNT_LOCKED("login account locked", "206"),
    UN_LOGIN_LOGOUT("un login request the logout", "207");


    private String message;
    private String code;

    ResultInfo(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return this.code;
    }
}

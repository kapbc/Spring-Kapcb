package com.kapcb.ccc.common.constants;

/**
 * <a>Title: ResultInfo </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/13 22:30
 */
public enum ResultInfo {

    /**
     * 状态码
     */
    SUCCESS("success", "200"),
    FAIL("fail", "201"),
    LOGIN_FAIL("login fail", "202"),
    LOGIN_ERROR("username or password error", "203"),
    LOGIN_EXCEPTION("account login exception", "204"),
    LOGIN_LOCKED("account locked", "205");

    private String message;
    private String code;

    ResultInfo(String message, String code) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}

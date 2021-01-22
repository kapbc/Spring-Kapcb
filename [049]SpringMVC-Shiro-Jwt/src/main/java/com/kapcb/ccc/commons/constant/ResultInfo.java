package com.kapcb.ccc.commons.constant;

/**
 * <a>Title: ResultInfo </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/22-15:03
 */
public enum ResultInfo {

    /**
     * api result
     */
    SUCCESS("success", "200"),
    FAIL("fail", "201"),
    INVALID("invalid request", "202"),
    EXCEPTION("system exception", "203"),
    LOCKED("account locked", "204"),
    UN_LOGIN("need to login", "205");

    private final String message;
    private final String code;

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

package com.kapcb.ccc.commons.bean;

import com.sun.deploy.net.HttpUtils;
import org.springframework.http.HttpStatus;

/**
 * <a>Title: ResultInfo </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/11 22:07
 */
public enum ResultInfo {

    /**
     * API status code and message
     */
    SUCCESS("success", "200"),
    FAIL("fail", "201"),
    LOGIN_ERROR("username or password error", "202"),
    LOGIN_ACCOUNT_LOCKED("account locked", "203"),
    LOGIN_ACCOUNT_EXCEPTION("login account exception", "204"),
    UN_LOGIN_ACCESS_LOGOUT("please login first", "205");

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

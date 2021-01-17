package com.kapcb.ccc.commons.bean;

/**
 * <a>Title: ResultInfo </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/17 20:46
 */
public enum ResultInfo {

    SUCCESS("success", "200"),
    FAIL("fail", "201"),
    ERROR_REQUEST("error request", "202");


    private String code;
    private String message;

    ResultInfo(String code, String message) {
        this.message = message;
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}

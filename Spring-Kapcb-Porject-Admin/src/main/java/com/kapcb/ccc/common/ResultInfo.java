package com.kapcb.ccc.common;

/**
 * <a>Title: ResultInfo </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/2 21:59
 */
public enum ResultInfo {

    REQUEST_SUCCESS("success", 200),
    REQUEST_FAIL("fail", 201);


    private String StatusMessage;
    private Integer StatusCode;

    ResultInfo(String statusMessage, Integer statusCode) {
        this.StatusCode = statusCode;
        this.StatusMessage = statusMessage;
    }

    public String statusMessage() {
        return this.StatusMessage;
    }

    public Integer statusCode() {
        return this.StatusCode;
    }
}

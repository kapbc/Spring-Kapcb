package com.kapcb.ccc.common;

import lombok.Data;

/**
 * <a>Title: ResultInfo </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/1 22:21
 */
public enum ResultInfo {

    /**
     * request process success
     */
    REQUEST_SUCCESS("success", 200),
    /**
     * request process fail
     */
    REQUEST_FAIL("fail", 201),
    /**
     * request time out
     */
    REQUEST_TIME_OUT("time out", 408),

    /**
     * request illegal param
     */
    REQUEST_ILLEGAL_PARAM("illegal param", 400),
    /**
     * request data not found
     */
    REQUEST_NOT_FOUND("data not found", 404);

    private String message;
    private Integer statusCode;

    ResultInfo(String message, Integer statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}

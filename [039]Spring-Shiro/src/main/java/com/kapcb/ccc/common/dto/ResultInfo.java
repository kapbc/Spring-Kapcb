package com.kapcb.ccc.common.dto;

/**
 * <a>Title: ResultInfo </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/8 20:47
 */
public enum ResultInfo {

    /**
     * result status code and message for api data
     */
    SUCCESS("success", "200"),
    FAIL("fail", "201");

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

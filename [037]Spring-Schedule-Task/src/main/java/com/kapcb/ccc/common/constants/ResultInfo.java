package com.kapcb.ccc.common.constants;

/**
 * <a>Title: ResultInfo </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/6 21:48
 */
public enum ResultInfo {

    /**
     * Result Information For Convert JSON API
     */
    SUCCESS("success", 200),
    NO_DATA_TO_CONVERT("no data for api", 205),
    FAIL("fail", 201);

    private final String statusMessage;
    private final Integer statusCode;

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    ResultInfo(String statusMessage, Integer statusCode) {
        this.statusMessage = statusMessage;
        this.statusCode = statusCode;
    }
}
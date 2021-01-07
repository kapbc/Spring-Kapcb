package com.kapcb.ccc.common.bean;

/**
 * <a>Title: ResultStatusInfo </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/7-11:08
 */
public enum ResultStatusInfo {

    /**
     * result status info for api
     */
    SUCCESS("success", "200"),
    FAIL("fail", "201");

    private String statusMessage;
    private String statusCode;

    ResultStatusInfo(String statusMessage, String statusCode) {
        this.statusMessage = statusMessage;
        this.statusCode = statusCode;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }
}

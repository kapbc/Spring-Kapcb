package com.kapcb.ccc.commons.constants;

/**
 * <a>Title: ResultInfo </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/3-9:21
 */
public enum ResultInfo {

    /**
     * system json api constants
     */
    SUCCESS("200", "process request success", "success"),
    FAIL("201", "process request fail", "fail");
    private final String message;
    private final String code;

    ResultInfo(String code, String message, String description) {
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

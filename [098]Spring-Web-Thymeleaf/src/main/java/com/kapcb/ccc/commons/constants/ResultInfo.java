package com.kapcb.ccc.commons.constants;

/**
 * <a>Title: ResultInfo </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/9 11:44
 */
public enum ResultInfo {

    /**
     * system json api constants
     */
    SUCCESS("200", "process request success", "success"),
    FAIL("201", "process request fail", "fail"),
    JSON_RESULT_CODE("code", "401"),
    JSON_RESULT_MESSAGE("message", "system error"),
    JSON_RESULT_DATA("data", "json result api empty result data key"),
    JSON_RESULT_NULL_DATA("", "json result api empty result data"),
            ;
    private final String message;
    private final String code;

    ResultInfo(String code, String message, String description) {
        this.code = code;
        this.message = message;
    }

    ResultInfo(String code, String message) {
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

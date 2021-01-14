package com.kapcb.ccc.common.bean;

import com.kapcb.ccc.common.constants.ResultInfo;
import lombok.Data;

/**
 * <a>Title: Result </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/13 22:28
 */
@Data
public class Result<T> {

    private String message;
    private String code;
    private T data;

    public Result() {
    }

    public Result(String message, String code) {
        this.message = message;
        this.code = code;
        this.data = null;
    }

    public Result(ResultInfo resultInfo) {
        this.message = resultInfo.getMessage();
        this.code = resultInfo.getCode();
        this.data = null;
    }

    public Result(ResultInfo resultInfo, T data) {
        this.message = resultInfo.getMessage();
        this.code = resultInfo.getCode();
        this.data = data;
    }
}

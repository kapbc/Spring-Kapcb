package com.kapcb.ccc.commons.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * <a>Title: Result </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/17 20:46
 */
@Data
@SuppressWarnings("serial")
public class Result<T> implements Serializable {

    private String message;
    private String code;
    private T data;

    public Result() {
    }

    public Result(ResultInfo resultInfo) {
        this.code = resultInfo.getCode();
        this.message = resultInfo.getMessage();
    }

    public Result(ResultInfo resultInfo, T data) {
        this.code = resultInfo.getCode();
        this.message = resultInfo.getMessage();
        this.data = data;
    }
}

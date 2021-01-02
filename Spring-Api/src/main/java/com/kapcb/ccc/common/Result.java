package com.kapcb.ccc.common;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * <a>Title: Result </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/1 22:18
 */
@Data
@ToString
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -6440971546399283052L;

    private String message;
    private Integer statusCode;
    private T data;

    private Result() {
    }

    public Result(ResultInfo resultInfo) {
        this.message = resultInfo.getMessage();
        this.statusCode = resultInfo.getStatusCode();
        this.data = null;
    }

    public Result(ResultInfo resultInfo, T data) {
        this.message = resultInfo.getMessage();
        this.statusCode = resultInfo.getStatusCode();
        this.data = data;
    }

    public Result(T data) {
        this.data = data;
    }
}

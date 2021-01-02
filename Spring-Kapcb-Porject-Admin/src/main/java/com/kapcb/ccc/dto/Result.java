package com.kapcb.ccc.dto;

import com.kapcb.ccc.common.ResultInfo;
import lombok.Data;

import java.io.Serializable;

/**
 * <a>Title: Result </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/2 21:59
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -6203824545352284738L;

    private String statusMessage;
    private Integer statusCode;
    private T data;

    public Result() {
    }

    public Result(ResultInfo resultInfo) {
        this.data = null;
        this.statusCode = resultInfo.statusCode();
        this.statusMessage = resultInfo.statusMessage();
    }

    public Result(ResultInfo resultInfo, T data) {
        this.data = data;
        this.statusCode = resultInfo.statusCode();
        this.statusMessage = resultInfo.statusMessage();
    }
}

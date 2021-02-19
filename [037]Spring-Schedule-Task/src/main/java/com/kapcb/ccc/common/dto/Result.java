package com.kapcb.ccc.common.dto;

import com.kapcb.ccc.common.constants.ResultInfo;
import lombok.Data;

import java.io.Serializable;

/**
 * <a>Title: Result </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/6 21:46
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 8706643501570674152L;
    private String statusMessage;
    private Integer statusCode;
    private T data;

    public Result() {
    }

    /**
     * For No DATA  EG: FAIL
     *
     * @param resultInfo ResultInfo
     */
    public Result(ResultInfo resultInfo) {
        this.statusMessage = resultInfo.getStatusMessage();
        this.statusCode = resultInfo.getStatusCode();
    }

    public Result(ResultInfo resultInfo, T data) {
        this.statusMessage = resultInfo.getStatusMessage();
        this.statusCode = resultInfo.getStatusCode();
        this.data = data;
    }
}
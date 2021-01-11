package com.kapcb.ccc.commons.dto;

import com.kapcb.ccc.commons.bean.ResultInfo;
import lombok.Data;

/**
 * <a>Title: Result </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/11 22:22
 */
@Data
public class Result<T> {

    private String message;
    private String code;
    private T data;

    public Result() {
    }

    public Result(ResultInfo resultInfo) {
        this.message = resultInfo.getMessage();
        this.code = resultInfo.getCode();
    }

    public Result(ResultInfo resultInfo, T data) {
        this.message = resultInfo.getMessage();
        this.code = resultInfo.getCode();
        this.data = data;
    }
}

package com.kapcb.ccc.domain;

import com.kapcb.ccc.constants.ResultInfo;
import com.kapcb.ccc.constants.ResultInfo;
import lombok.Data;

/**
 * <a>Title: ResultBean </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/3-9:18
 */
@Data
public class ResultBean<T> {

    private String message;
    private String code;
    private T data;

    public ResultBean() {
    }

    public ResultBean(String message, String code) {
        this.message = message;
        this.code = code;
        this.data = null;
    }

    public ResultBean(String message, String code, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public ResultBean(ResultInfo resultInfo) {
        this.data = null;
        this.code = resultInfo.getCode();
        this.message = resultInfo.getMessage();
    }

    public ResultBean(ResultInfo resultInfo, T data) {
        this.data = data;
        this.code = resultInfo.getCode();
        this.message = resultInfo.getMessage();
    }
}

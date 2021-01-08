package com.kapcb.ccc.common.bean;

import com.kapcb.ccc.common.dto.ResultInfo;
import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.Member;

/**
 * <a>Title: ResultBean </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/8 20:46
 */
@Data
public class ResultBean<T> implements Serializable {

    private static final long serialVersionUID = -2228066219816284105L;

    private String message;
    private String code;
    private T data;

    public ResultBean(){}

    public ResultBean(ResultInfo resultInfo) {
        this.message = resultInfo.getMessage();
        this.code = resultInfo.getCode();
        this.data = null;
    }

    public ResultBean(ResultInfo resultInfo, T data) {
        this.message = resultInfo.getMessage();
        this.code = resultInfo.getCode();
        this.data = data;
    }
}

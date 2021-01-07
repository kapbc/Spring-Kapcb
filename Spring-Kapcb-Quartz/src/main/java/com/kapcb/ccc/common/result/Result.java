package com.kapcb.ccc.common.result;

import com.kapcb.ccc.common.bean.ResultStatusInfo;
import lombok.Data;

/**
 * <a>Title: Result </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/7-11:06
 */
@Data
public class Result<T> {

    private String statusMessage;
    private String statusCode;
    private T data;

    public Result() {
    }

    public Result(ResultStatusInfo resultStatusInfo) {
        this.statusCode = resultStatusInfo.getStatusCode();
        this.statusMessage = resultStatusInfo.getStatusMessage();
        this.data = null;
    }

    public Result(ResultStatusInfo resultStatusInfo, T data) {
        this.statusCode = resultStatusInfo.getStatusCode();
        this.statusMessage = resultStatusInfo.getStatusMessage();
        this.data = data;
    }
}

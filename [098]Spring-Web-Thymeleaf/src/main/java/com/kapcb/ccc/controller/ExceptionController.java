package com.kapcb.ccc.controller;

import com.kapcb.ccc.commons.constants.ResultInfo;
import com.kapcb.ccc.commons.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <a>Title: ExceptionController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/8 17:18
 */
@Slf4j
@ResponseBody
@ControllerAdvice
public class ExceptionController {


    @ExceptionHandler(Exception.class)
    public String SystemExceptionHandler(Exception e) {
        log.error("system process error, the exception is : " + e.getMessage(), e);
        JsonUtil.JsonBuilder jsonBuilder = new JsonUtil.JsonBuilder();
        return jsonBuilder.put(ResultInfo.JSON_RESULT_MESSAGE.getCode(), ResultInfo.JSON_RESULT_MESSAGE.getMessage())
                .put(ResultInfo.JSON_RESULT_CODE.getCode(), ResultInfo.JSON_RESULT_CODE.getMessage())
                .put(ResultInfo.JSON_RESULT_DATA.getCode(), ResultInfo.JSON_RESULT_NULL_DATA.getCode()).builder();
    }
}

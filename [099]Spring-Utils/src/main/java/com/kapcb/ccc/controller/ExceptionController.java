package com.kapcb.ccc.controller;

import com.kapcb.ccc.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <a>Title: ExceptionController </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/7-9:35
 */
@ResponseBody
@ControllerAdvice
public class ExceptionController {

    private static final Logger log = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(Exception.class)
    public String handlerSystemException(Exception e) {
        log.error("handler system exception, the exception message is : " + e.getMessage());
        JsonUtil.JsonBuilder jsonBuilder = new JsonUtil.JsonBuilder();
        return jsonBuilder
                .put("message", e.getMessage())
                .put("code", "401")
                .put("data", "")
                .builder();
    }
}

package com.kapcb.ccc.controller;

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
        log.error("system process error, the exception is : "+e.getMessage(),e);
        return "";
    }
}

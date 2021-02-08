package com.kapcb.ccc.controller;

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
 * @date 2021/2/7-16:40
 */
@ResponseBody
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler
    public String SystemExceptionHandler(Exception e) {
        return e.getMessage();
    }
}

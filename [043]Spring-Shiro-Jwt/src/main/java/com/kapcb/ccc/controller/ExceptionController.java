package com.kapcb.ccc.controller;

import com.kapcb.ccc.common.bean.Result;
import com.kapcb.ccc.common.constants.ResultInfo;
import com.kapcb.ccc.common.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * <a>Title: ExceptionController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 * 处理全局异常
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/14 22:54
 */
@Slf4j
@ControllerAdvice
public class ExceptionController {

    /**
     * 捕捉 shiro 的异常
     *
     * @param e ShiroException
     * @return String
     */
    @ExceptionHandler(ShiroException.class)
    public String handleShiroException(ShiroException e) {
        return JsonUtil.convertObjectToJsonString(new Result<>(e.getMessage(), "401"));
    }

    /**
     * 捕捉其它所有异常类
     *
     * @param request   HttpServletRequest
     * @param throwable Throwable
     * @return String
     */
    @ExceptionHandler(Exception.class)
    public String handleGlobalException(HttpServletRequest request, Throwable throwable) {
        return JsonUtil.convertObjectToJsonString(new Result<>(throwable.getMessage(), "401"));
    }

}

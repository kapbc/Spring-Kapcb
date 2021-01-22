package com.kapcb.ccc.controller;

import com.kapcb.ccc.commons.constant.ResultInfo;
import com.kapcb.ccc.commons.domain.Result;
import com.kapcb.ccc.commons.utils.json.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * <a>Title: ExceptionController </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/22-15:43
 */
@Slf4j
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ShiroException.class)
    public String handlerShiroException(ShiroException e) {
        log.info("handler shiro exception");
        return JsonUtil.convertResultToJsonString(new Result<>(ResultInfo.EXCEPTION));
    }

    @ExceptionHandler(Exception.class)
    public String handlerSystemException(Exception e) {
        log.info("handler system exception");
        return JsonUtil.convertResultToJsonString(new Result<>(ResultInfo.EXCEPTION));
    }
}

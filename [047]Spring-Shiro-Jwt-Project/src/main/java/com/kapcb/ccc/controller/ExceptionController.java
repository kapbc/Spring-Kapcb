package com.kapcb.ccc.controller;

import com.kapcb.ccc.commons.constants.Constant;
import com.kapcb.ccc.commons.domain.Result;
import com.kapcb.ccc.commons.utils.JsonUtil;
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
 * @date 2021/1/21-10:06
 */
@Slf4j
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = ShiroException.class)
    public String handlerShiroException(ShiroException e) {
        log.warn("handler shiro exception in exception controller");
        log.warn("the exception message is : " + e.getMessage());
        return JsonUtil.convertToJsonString(new Result<>(e.getMessage(), Constant.FOUR_ZERO_ONE.getString()));
    }

    @ExceptionHandler(value = Exception.class)
    public String handlerSystemException(Exception e) {
        log.warn("handler system exception in exception controller");
        log.warn("the exception message is : " + e.getMessage());
        return JsonUtil.convertToJsonString(new Result<>(e.getMessage(), Constant.FOUR_ZERO_ZEO.getString()));
    }
}

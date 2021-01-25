package com.kapcb.ccc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

/**
 * <a>Title: ExceptionHandlerController </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/25-14:50
 * <p>
 * https://www.cnblogs.com/joimages/p/13468399.html
 */
@ResponseBody
@ControllerAdvice
public class ExceptionHandlerController {

    private static final Logger log = LoggerFactory.getLogger(ExceptionHandlerController.class);

    /**
     * 处理 form data方式调用接口校验失败抛出的异常
     *
     * @param e BindException
     * @return String
     */
    @ExceptionHandler(BindException.class)
    public String handlerBindException(BindException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        String result = fieldErrors.stream().map(ObjectError::getDefaultMessage).reduce((msgOne, msgTwo) -> msgOne + ", " + msgTwo).get();
        log.info("the result in handlerBindException : " + result);
        return result;
    }

    /**
     * 处理 json 请求体调用接口校验失败抛出的异常
     *
     * @param e MethodArgumentNotValidException
     * @return String
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        String result = fieldErrors.stream().map(ObjectError::getDefaultMessage).reduce((msgOne, msgTwo) -> msgOne + "/" + msgTwo).get();
        log.info("the result in handlerMethodArgumentNotValidException : " + result);
        return result;
    }

    /**
     * 处理单个参数校验失败抛出的异常
     * 单个参数校验需要在参数上增加校验注解，并在类上标注@Validated
     * @param e ConstraintViolationException
     * @return String
     */
    @ExceptionHandler({ConstraintViolationException.class})
    public String handlerConstraintViolationException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        String result = constraintViolations.stream().map(ConstraintViolation::getMessage).reduce((msgOne, msgTwo) -> msgOne + "/" + msgTwo).get();
        log.info("the result in handlerConstraintViolationException : " + result);
        return result;
    }
}

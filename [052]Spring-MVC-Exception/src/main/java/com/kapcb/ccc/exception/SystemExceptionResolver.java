package com.kapcb.ccc.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <a>Title: SystemExceptionResolver </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/23 23:08
 */
public class SystemExceptionResolver implements HandlerExceptionResolver {

    private static final Logger log = LoggerFactory.getLogger(SystemExceptionResolver.class);

    /**
     * 转到具体的错误页面的方法
     *
     * @param httpServletRequest  HttpServletRequest
     * @param httpServletResponse HttpServletResponse
     * @param o                   Object
     * @param e                   Exception
     * @return ModelAndView
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        e.printStackTrace();

        SystemException systemException = null;

        if (systemException instanceof SystemException) {
            systemException = (SystemException) e;
        } else {
            systemException = new SystemException("System error. Please connect with Admin");
        }

        ModelAndView modelAndView = new ModelAndView();

        /**
         * 提示错误信息
         */
        modelAndView.addObject("message", systemException.getMessage());

        /**
         * 指定跳转的错误 (error) 页面
         */
        modelAndView.setViewName("error");
        return modelAndView;
    }
}

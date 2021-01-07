package com.kapcb.ccc.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <a>Title:SystemExceptionResolver</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 * <p>
 * 自定义异常处理器
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/8 17:44
 */
public class SystemExceptionResolver implements HandlerExceptionResolver {

    /**
     * 跳转到具体的错误页面的方法
     *
     * @param request  httpServletRequest
     * @param response httpServletResponse
     * @param o        Object
     * @param e        Exception
     * @return modelAndView
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {

        e.printStackTrace();
        SystemException ex = null;

        //获取到异常对象
        if (ex instanceof SystemException) {
            ex = (SystemException) e;
        } else {
            ex = new SystemException("请联系管理员");
        }

        ModelAndView modelAndView = new ModelAndView();
        //提示错误信息
        modelAndView.addObject("message", ex.getMessage());
        //指定跳转的 jsp 页面
        modelAndView.setViewName("error");

        return modelAndView;
    }
}

package com.kapcb.ccc.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <a>Title: MyFirstInterceptor </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/24 22:48
 */
public class MyFirstInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(MyFirstInterceptor.class);

    /**
     * controller方法执行前，进行拦截的方法
     * return true放行
     * return false拦截
     * 可以使用转发或者重定向直接跳转到指定的页面。
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @param handler  Object
     * @return boolean
     * @throws Exception Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("come into the preHandler in Interceptor....");
        log.info("return true will pass, return false will handler...");
        return true;
    }

    /**
     * postHandle是controller方法执行后执行的方法，在JSP视图执行前
     * 可以使用request或者response跳转到指定的页面
     * 如果指定了跳转的页面，那么controller方法跳转的页面将不会显示
     *
     * @param request      HttpServletRequest
     * @param response     HttpServletResponse
     * @param handler      Object
     * @param modelAndView ModelAndView
     * @throws Exception Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("come into postHandler in Interceptor....");
        log.info("the postHandler is after Controller before internalViewResolver...");
        request.getRequestDispatcher("/WEB-INF/views/test.jsp").forward(request, response);
    }

    /**
     * afterCompletion方法是在视图解析之后执行
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @param handler  Object
     * @param ex       Exception
     * @throws Exception Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("come into afterCompletion in Interceptor...");
        log.info("the afterCompletion is after internalViewResolver...");
    }
}

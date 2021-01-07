package com.kapcb.ccc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <a>Title:MyFirstInterceptor</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 * <p>
 * 自定义拦截器
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/8 20:06
 */
public class MyFirstInterceptor implements HandlerInterceptor {

    /**
     * controller方法执行前，进行拦截的方法
     * return true放行
     * return false拦截
     * 可以使用转发或者重定向直接跳转到指定的页面。
     *
     * @param request  request
     * @param response response
     * @param handler  handler
     * @return boolean
     * @throws Exception Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器执行了。。。。");
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
        System.out.println("Controller方法执行之后，Jsp视图执行之前");
        request.getRequestDispatcher("/WEB-INF/views/test.jsp").forward(request, response);
    }
}


package com.kapcb.ccc.commons.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <a>Title: HttpInterceptor </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/17 22:28
 */
@Slf4j
public class HttpInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         * 允许跨域
         */
        response.setHeader("Access-Control-Allow-Origin", "*");

        /**
         * 允许自定义请求头accessToken(允许head跨域)
         */
        response.setHeader("Access-Control-Allow-Headers", "accessToken, Accept, Origin, X-Requested-With, Content-Type, Last-Modified");

        return false;
    }
}

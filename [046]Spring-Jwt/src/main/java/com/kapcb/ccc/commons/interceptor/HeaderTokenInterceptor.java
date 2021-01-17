package com.kapcb.ccc.commons.interceptor;

import com.kapcb.ccc.commons.jwt.JwtUtil;
import com.kapcb.ccc.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <a>Title: HeaderTokenInterceptor </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/17 20:42
 */
@Slf4j
public class HeaderTokenInterceptor implements HandlerInterceptor {

    private static final String LOGIN_URI = "login";
    private static final String TOKEN = "accessToken";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         * 获取我们请求头中的token验证字符
         */
        String token = request.getHeader(TOKEN);
        if (token == null) {
            response.getWriter().write(JsonUtil.convertBeanToString(null));
            return false;
        }
        /**
         * 检测当前页面,我们设置当页面不是登录页面时对其进行拦截
         * 具体方法就是检测URL中有没有login字符串
         */
        if (!request.getRequestURI().contains(LOGIN_URI)) {
            try {
                /**
                 * 验证并更新token
                 */
                token = JwtUtil.updateToken(token);
                log.warn("token verified success!");
                response.setHeader(TOKEN, token);
                return true;
            } catch (Exception e) {
                log.error("token verified fail! the exception is : " + e.getMessage());
            }
        }
        return false;
    }
}

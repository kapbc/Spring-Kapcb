package com.kapcb.ccc.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

/**
 * <a>Title: LoginCheckPermissionFilter </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/9 12:25
 */
@Slf4j
public class LoginCheckPermissionFilter extends AuthorizationFilter {

    /**
     * 此过滤器主要用于校验用户访问某个URL时，是否已经提前登录过，如果登录过，则允许访问，否则拒绝访问；
     * 此过滤器继承了AuthorizationFilter，并重写了isAccessAllowed方法和onAccessDenied方法
     *
     * @param request     ServletRequest
     * @param response    ServletResponse
     * @param mappedValue Object
     * @return boolean
     * @throws Exception Exception
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        String requestUri = req.getRequestURI();
        log.warn("requestUri is : " + requestUri);
        try {
            Subject subject = SecurityUtils.getSubject();
            return subject.isPermitted(requestUri);
        } catch (Exception e) {
            log.error("check request permission error : " + e.getMessage());
        }
        return false;
    }

    /**
     * 在onAccessDenied方法中，如果用户身份为空，说明未登录，则跳转到登录页面，
     * 如果未指定跳转的路径，Shiro给了默认值的跳转页面 /login.jsp
     *
     * @param request  ServletRequest
     * @param response ServletResponse
     * @return boolean
     * @throws IOException IOException
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        Subject subject = getSubject(request, response);
        log.warn("subject is : " + subject);
        if (Objects.equals(null, subject.getPrincipal())) {
            saveRequestAndRedirectToLogin(request, response);
        } else {
            return true;
        }
        return false;
    }

    @Override
    public void setLoginUrl(String loginUrl) {
        log.warn("login url is : " + loginUrl);
        super.setLoginUrl(loginUrl);
    }
}

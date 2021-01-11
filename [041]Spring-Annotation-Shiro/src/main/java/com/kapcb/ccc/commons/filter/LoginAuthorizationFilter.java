package com.kapcb.ccc.commons.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

/**
 * <a>Title: LoginAuthcFilter </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/10 21:44
 */
@Slf4j
@Component
public class LoginAuthorizationFilter extends AuthorizationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        String requestUri = req.getRequestURI();
        try {
            Subject subject = SecurityUtils.getSubject();
            return subject.isPermitted(requestUri);
        } catch (Exception e) {
            log.warn("request url is permitted judgement fail, the exception is : " + e.getMessage());
        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        Subject subject = getSubject(request, response);
        if (!Objects.equals(null, subject.getPrincipal())) {
            return true;
        }
        saveRequestAndRedirectToLogin(request, response);
        return false;
    }
}

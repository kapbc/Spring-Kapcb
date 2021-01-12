package com.kapcb.ccc.common.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * <a>Title: KapcbLoginFilter </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/12 21:04
 */
@Slf4j
@Component
public class KapcbLoginFilter extends AuthorizationFilter {


    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        String requestUri = req.getRequestURI();
        log.warn("requestUrl is : " + requestUri);
        try {
            Subject subject = SecurityUtils.getSubject();
            return subject.isPermitted(requestUri);
        } catch (Exception e) {
            log.error("process is access allowed request uri error, the exception is : " + e.getMessage());
        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Subject subject = getSubject(request, response);
        if (Objects.equals(subject.getPrincipal(), null)) {
            saveRequestAndRedirectToLogin(request, response);
            return false;
        }
        return true;
    }
}

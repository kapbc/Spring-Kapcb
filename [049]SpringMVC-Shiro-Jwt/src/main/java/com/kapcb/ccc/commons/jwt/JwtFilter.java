package com.kapcb.ccc.commons.jwt;

import com.kapcb.ccc.commons.constant.Constants;
import com.kapcb.ccc.commons.utils.jwt.JwtUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * <a>Title: JwtFilter </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/22-11:34
 */
@Slf4j
@Component
public class JwtFilter extends BasicHttpAuthenticationFilter {


    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        if (StringUtils.equals(WebUtils.toHttp(request).getMethod(), RequestMethod.OPTIONS.name())) {
            WebUtils.toHttp(response).setStatus(HttpStatus.OK.value());
        }
        return super.preHandle(request, response);
    }

    @Override
    protected void postHandle(ServletRequest request, ServletResponse response) throws Exception {
        this.fillCorsHeader(WebUtils.toHttp(request), WebUtils.toHttp(response));
    }

    @Override
    @SneakyThrows(value = {IllegalStateException.class, Exception.class})
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (isLoginRequest(request, response)) {
            return false;
        }
        boolean isAllowedAccess = false;
        isAllowedAccess = executeLogin(request, response);
        log.info("the shiro execute login result is : " + isAllowedAccess);
        return isAllowedAccess || super.isPermissive(mappedValue);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        httpServletResponse.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        httpServletResponse.setContentType(Constants.HTTP_RESPONSE_CONTENT_TYPE.getString());
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write("{\"code\": 401, \"message\": \"unauthorized\"}");
        fillCorsHeader(WebUtils.toHttp(request), httpServletResponse);
        return false;
    }

    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        return Objects.equals(WebUtils.toHttp(request).getHeader(Constants.JWT_AUTHORIZATION_HEARD.getString()), null);
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        AuthenticationToken token = createToken(request, response);
        if (token == null) {
            throw new IllegalStateException("the token is null");
        }
        try {
            Subject subject = getSubject(request, response);
            subject.login(token);
            return onLoginSuccess(token, subject, request, response);
        } catch (AuthenticationException e) {
            return onLoginFailure(token, e, request, response);
        }
    }

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        String header = WebUtils.toHttp(request).getHeader(Constants.JWT_AUTHORIZATION_HEARD.getString());
        return header == null ? null : new JwtToken(header);
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
        String newToken = null;
        if (token instanceof JwtToken) {
            /**
             * 每次请求都更新一次token以及token中的过期时间
             */
            newToken = JwtUtil.refreshExpireTimeToken(token.getCredentials().toString(), Constants.JWT_SECRET.getString());
        }
        if (newToken != null) {
            httpServletResponse.setHeader(Constants.JWT_AUTHORIZATION_HEARD.getString(), newToken);
        }
        return true;
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        return false;
    }

    protected void fillCorsHeader(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,HEAD");
        response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
    }

}

package com.kapcb.ccc.commons.jwt;

import com.kapcb.ccc.commons.constants.Constant;
import com.kapcb.ccc.commons.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
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
 * @date 2021/1/20-14:29
 */
@Slf4j
@Component
public class JwtFilter extends BasicHttpAuthenticationFilter {

    /**
     * 前置处理，给跨域请求返回正常状态
     *
     * @param request  ServletRequest
     * @param response ServletResponse
     * @return boolean
     * @throws Exception
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
        HttpServletResponse httpServletResponse = WebUtils.toHttp(response);

        if (Objects.equals(httpServletRequest.getMethod(), RequestMethod.OPTIONS.name())) {
            log.warn("is the option request if the request");
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }

    /**
     * 后置处理 支持跨域请求
     *
     * @param request  ServletRequest
     * @param response ServletResponse
     */
    @Override
    protected void postHandle(ServletRequest request, ServletResponse response) {
        this.fillCorsHeader(WebUtils.toHttp(request), WebUtils.toHttp(response));
    }

    /**
     * 过滤拦截请求的入口方法
     * 返回 ture 允许访问
     * 返回 false 禁止访问，进入 onAccessDenied() 方法
     *
     * @param request     ServletRequest
     * @param response    ServletResponse
     * @param mappedValue Object
     * @return boolean
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (this.isLoginRequest(request, response)) {
            return false;
        }
        boolean allowed = false;
        try {
            allowed = executeLogin(request, response);
            log.info("the token execute login result is : " + allowed);
        } catch (IllegalStateException e) {
            log.error("Not found any token, the exception is : " + e.getMessage());
        } catch (Exception e) {
            log.error("login error, the exception is : " + e.getMessage());
        }
        return allowed || super.isPermissive(mappedValue);
    }

    /**
     * isAccessAllowed() 方法返回 false 就会进入到该方法， 认证失败
     *
     * @param request  ServletRequest
     * @param response ServletResponse
     * @return boolean
     * @throws Exception Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        httpServletResponse.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        httpServletResponse.setContentType(Constant.HTTP_RESPONSE_CONTENT_TYPE.getString());
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write("{\"code\": 401, \"message\": \"unauthorized\"}");
        fillCorsHeader(WebUtils.toHttp(request), WebUtils.toHttp(response));
        return false;
    }

    /**
     * 判断 request 中是携带符合要求的 JwtToken
     *
     * @param request  ServletRequest
     * @param response ServletResponse
     * @return boolean
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        return Objects.equals(null, WebUtils.toHttp(request).getHeader(Constant.JWT_AUTHORIZATION_HEARD.getString()));
    }

    /**
     * 交由 Shiro 使用 JwtToken 进行登录
     *
     * @param request  ServletRequest
     * @param response ServletResponse
     * @return boolean
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) {
        AuthenticationToken token = this.createToken(request, response);
        if (token == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("createToken method implementation returned null. ");
            sb.append("A valid non-null AuthenticationToken ");
            sb.append("must be created in order to execute a login attempt.");
            log.warn(sb.toString());
            throw new IllegalStateException(sb.toString());
        }
        try {
            Subject subject = getSubject(request, response);
            subject.login(token);
            return onLoginSuccess(token, subject, request, response);
        } catch (AuthenticationException e) {
            return onLoginFailure(token, e, request, response);
        }
    }

    /**
     * 获取 request 中 heard 部分的 token 值，并创建一个 JwtToken 返回
     *
     * @param request  ServletRequest
     * @param response ServletResponse
     * @return AuthenticationToken
     */
    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
        String header = httpServletRequest.getHeader(Constant.JWT_AUTHORIZATION_HEARD.getString());
        log.warn("the request heard is : " + header);
        return new JwtToken(header);
    }

    /**
     * Shiro 使用 JwtToken 登录， 成功会进入该方法，成功之后签发新的 JwtToken 并返回
     *
     * @param token    AuthenticationToken
     * @param subject  Subject
     * @param request  ServletRequest
     * @param response ServletResponse
     * @return boolean
     */
    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) {
        HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
        String newToken = null;
        if (token instanceof JwtToken) {
            newToken = JwtUtil.refreshExpireTimeToken(token.getCredentials().toString(), Constant.JWT_SECRET.getString());
        }
        if (newToken != null) {
            httpServletResponse.setHeader(Constant.JWT_AUTHORIZATION_HEARD.getString(), newToken);
        }
        return true;
    }

    /**
     * Shiro 使用 JwtToken 登录， 失败会进入该方法
     *
     * @param token    AuthenticationToken
     * @param e        AuthenticationException
     * @param request  ServletRequest
     * @param response ServletResponse
     * @return boolean
     */
    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        return false;
    }

    /**
     * 添加跨域支持
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     */
    private void fillCorsHeader(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,HEAD");
        response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
    }
}

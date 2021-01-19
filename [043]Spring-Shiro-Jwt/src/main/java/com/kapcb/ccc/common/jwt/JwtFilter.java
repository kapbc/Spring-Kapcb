package com.kapcb.ccc.common.jwt;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.http.HttpStatus;
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
 * <a>Description: <a>
 * <p>
 * 自定义的认证过滤器，用来拦截Header中携带 JWT token的请求
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/14 20:38
 */
@Slf4j
public class JwtFilter extends BasicHttpAuthenticationFilter {

    /**
     * 前置处理
     *
     * @param servletRequest  ServletRequest
     * @param servletResponse ServletResponse
     * @return boolean
     */
    @Override
    protected boolean preHandle(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest httpServletRequest = WebUtils.toHttp(servletRequest);
        HttpServletResponse httpServletResponse = WebUtils.toHttp(servletResponse);
        /**
         * 跨域请求时会先发送一个 option 请求, 这里给 option 请求直接返回正常状态
         */
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(servletRequest, servletResponse);
    }

    /**
     * 后置处理
     *
     * @param request  ServletRequest
     * @param response ServletResponse
     * @throws Exception Exception
     */
    @Override
    protected void postHandle(ServletRequest request, ServletResponse response) throws Exception {
        /**
         * 添加跨域支持
         */
        this.fillCorsHeader(WebUtils.toHttp(request), WebUtils.toHttp(response));
    }


    /**
     * 过滤器拦截请求的入口方法
     * 返回 true 允许访问
     * 返回 false 禁止访问, 会进入 onAccessDenied()
     *
     * @param request     ServletRequest
     * @param response    ServletResponse
     * @param mappedValue Object
     * @return boolean
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        /**
         * 原用来判断是否是登录请求，在本例中不会拦截登录请求，用来检测Header中是否包含 JWT token 字段
         */
        if (this.isLoginAttempt(request, response)) {
            return false;
        }
        boolean allowed = false;
        try {
            /**
             * 检测Header里的 JWT token内容是否正确，尝试使用 token进行登录
             */
            allowed = executeLogin(request, response);
        } catch (IllegalStateException e) {
            log.error("Not Found Any Token");
        } catch (Exception e) {
            log.error("login error, the exception is : " + e.getMessage());
        }
        return allowed || super.isPermissive(mappedValue);
    }

    /**
     * 测Header中是否包含 JWT token 字段
     *
     * @param request  ServletRequest
     * @param response ServletResponse
     * @return boolean
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        return Objects.equals(null, WebUtils.toHttp(request).getHeader(JwtUtil.AUTH_HEADER));
    }

    /**
     * 身份验证, 检查 JWT token 是否合法
     *
     * @param request  ServletRequest
     * @param response ServletResponse
     * @return boolean
     * @throws Exception Exception
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        AuthenticationToken token = createToken(request, response);
        if (Objects.equals(null, token)) {
            StringBuilder sb = new StringBuilder();
            sb.append("createToken method implementation returned null. ");
            sb.append("A valid non-null AuthenticationToken ");
            sb.append("must be created in order to execute a login attempt.");
            log.warn(sb.toString());
            throw new IllegalStateException(sb.toString());
        }
        try {
            Subject subject = getSubject(request, response);
            /**
             * 交由 Shiro 进行登录验证
             */
            subject.login(token);
            return onLoginSuccess(token, subject, request, response);
        } catch (AuthenticationException e) {
            return onLoginFailure(token, e, request, response);
        }
    }

    /**
     * 从请求的 Header 中提取 JwtToken
     *
     * @param request  ServletRequest
     * @param response ServletResponse
     * @return AuthenticationToken
     */
    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
        String authorization = httpServletRequest.getHeader(JwtUtil.AUTH_HEADER);
        return new JwtToken(authorization);
    }

    /**
     * isAccessAllowed() 方法返回 false , 会进入该方法, 表示拒绝访问
     *
     * @param request  ServletRequest
     * @param response ServletResponse
     * @return boolean
     * @throws Exception Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
        httpServletResponse.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        httpServletResponse.setContentType("application/json; charset = UTF-8");
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write("{\"code\": 401, \"message\": \"unauthorized\"}");
        fillCorsHeader(WebUtils.toHttp(request), httpServletResponse);
        return false;
    }

    /**
     * Shiro 利用 Jwt token 登录成功, 会进入该方法
     *
     * @param authenticationToken AuthenticationToken
     * @param subject             Subject
     * @param request             ServletRequest
     * @param response            ServletResponse
     * @return boolean
     * @throws Exception Exception
     */
    @Override
    protected boolean onLoginSuccess(AuthenticationToken authenticationToken, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
        String newToken = null;
        if (authenticationToken instanceof JwtToken) {
            newToken = JwtUtil.refreshTokenExpireTime(authenticationToken.getCredentials().toString(), JwtUtil.CONFIDENTIAL);
        }
        if (!Objects.equals(null, newToken)) {
            httpServletResponse.setHeader(JwtUtil.AUTH_HEADER, newToken);
        }
        return true;
    }


    /**
     * Shiro 利用 Jwt token 登录失败, 会进入该方法
     *
     * @param token    AuthenticationToken
     * @param e        AuthenticationException
     * @param request  ServletRequest
     * @param response ServletResponse
     * @return boolean
     */
    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        /**
         * 此处直接返回 false ，交给后面的  onAccessDenied()方法进行处理
         */
        return false;
    }

    /**
     * 添加跨域支持
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     */
    protected void fillCorsHeader(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,HEAD");
        response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
    }
}

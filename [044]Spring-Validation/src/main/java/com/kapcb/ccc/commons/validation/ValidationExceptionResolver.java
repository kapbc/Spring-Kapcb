package com.kapcb.ccc.commons.validation;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <a>Title: ValidationExceptionResolver </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/22 21:35
 */
@Slf4j
public class ValidationExceptionResolver extends AbstractHandlerExceptionResolver {

    /**
     * 设置order, 在DefaultHandlerExceptionResolver之前执行, 或者使用@Order注解
     */
    @PostConstruct
    public void initConfig() {
        setOrder(0);
    }

    /**
     * Handler the case where an argument annotation with {@code @Valid} such as
     * an {@link} or {@link} argument fails validation
     * <p>
     * 自定义ValidationException异常处理器
     * 获取到具体的 validation 错误信息, 并组装 CommonResponse, 返回给调用方
     *
     * @param request       HttpServletRequest
     * @param response      HttpServletResponse
     * @param handler       Current execute handler Object
     * @param bindingResult BindingResult
     * @return An empty ModelAndView indicating the exception that was handler
     */
    @ResponseBody
    @SneakyThrows(Exception.class)
    protected ModelAndView handlerMethodArgumentNotValidException(HttpServletRequest request, HttpServletResponse response, Object handler, BindingResult bindingResult) {
        /**
         * 获取错误信息
         */
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        String errorMessage = allErrors.stream().map(ObjectError::getObjectName).collect(Collectors.joining(", "));
        log.info("Validation failed! {}", errorMessage);

        /**
         * 封装返回体
         */
        Map<String, String> resultMap = new HashMap<>(16);
        resultMap.put("code", "400");
        resultMap.put("message", errorMessage);

        ModelAndView modelAndView = new ModelAndView();
        MappingJackson2JsonView mappingJackson2JsonView = new MappingJackson2JsonView();
        mappingJackson2JsonView.setAttributesMap(resultMap);
        modelAndView.setView(mappingJackson2JsonView);

        return modelAndView;
    }


    @Override
    protected ModelAndView doResolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        BindingResult bindingResult = null;
        if (e instanceof MethodArgumentNotValidException) {
            bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
        }
        if (e instanceof BindException) {
            bindingResult = ((BindException) e).getBindingResult();
        }
        // if (e instanceof XXXException) ... other exception , ignore

        if (bindingResult != null) {
            return handlerMethodArgumentNotValidException(httpServletRequest, httpServletResponse, o, bindingResult);
        }
        return null;
    }
}

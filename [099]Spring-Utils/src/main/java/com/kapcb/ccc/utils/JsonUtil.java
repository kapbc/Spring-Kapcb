package com.kapcb.ccc.commons.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kapcb.ccc.commons.constants.ResultInfo;
import com.kapcb.ccc.commons.domain.ResultBean;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.Optional;

/**
 * <a>Title: JsonUtil </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/3-9:17
 */
public class JsonUtil {

    private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private JsonUtil() {
    }

    @SneakyThrows(value = JsonProcessingException.class)
    public static <T> String convertObjectBeanToJsonString(ResultBean<T> resultBean) {
        resultBean = Optional.ofNullable(resultBean).orElseGet(JsonUtil::getNullableResultBean);
        log.warn("process convert object bean to json string");
        return OBJECT_MAPPER.writeValueAsString(resultBean);
    }

    @SneakyThrows(value = JsonProcessingException.class)
    public static <T> String convertObjectBeanToJsonString(T data) {
        ResultBean nullableResultBean = getNullableResultBean(data);
        return OBJECT_MAPPER.writeValueAsString(nullableResultBean);
    }

    @SneakyThrows(value = JsonProcessingException.class)
    public static <T> String convertObjectToStringPretty(ResultBean<T> resultBean) {
        resultBean = Optional.ofNullable(resultBean).orElseGet(JsonUtil::getNullableResultBean);
        log.warn("process Object to String Pretty");
        return OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(resultBean);
    }

    @SneakyThrows(value = JsonProcessingException.class)
    public static <T> String convertObjectToStringPretty(T data) {
        ResultBean nullableResultBean = getNullableResultBean(data);
        return OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(nullableResultBean);
    }

    public static <T> String convertStringToObject(String jsonString, Class<T> clazz) {
        ResultBean nullableResultBean = getNullableResultBean(jsonString, clazz);
        OBJECT_MAPPER.readValue()
    }


    private static ResultBean getNullableResultBean() {
        return new ResultBean<>(ResultInfo.FAIL);
    }

    private static <T> ResultBean getNullableResultBean(T data) {
        return new ResultBean<>(Objects.equals(null, data) ? ResultInfo.FAIL : ResultInfo.SUCCESS, Objects.equals(null, data) ? "" : data);
    }

    private static <T> ResultBean getNullableResultBean(String jsonString, Class<T> clazz) {
        if (StringUtils.isBlank(jsonString) || clazz == null) {
            return new ResultBean<>(ResultInfo.FAIL, "");
        }
        return new ResultBean<>(ResultInfo.SUCCESS, jsonString);
    }
}

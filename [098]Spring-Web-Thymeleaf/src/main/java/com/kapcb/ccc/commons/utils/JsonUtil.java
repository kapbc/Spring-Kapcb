package com.kapcb.ccc.commons.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * <a>Title: JsonUtil </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/8 17:51
 */
@Slf4j
public class JsonUtil {

    private static final int INITIAL_CAPACITY = 16;
    private static final String DEFAULT_JSON_VALUE = "{}";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private JsonUtil() {
    }

    /**
     * convert Object bean to json String
     *
     * @param resultBean {@link ResultBean}
     * @param <T>        <T>
     * @return String
     */
    public static <T> String convertObjectBeanToJsonString(ResultBean<T> resultBean) {
        log.warn("process convert object bean to json string");
        resultBean = Optional.ofNullable(resultBean).orElseGet(JsonUtil::getNullableResultBean);
        try {
            return OBJECT_MAPPER.writeValueAsString(resultBean);
        } catch (JsonProcessingException e) {
            log.error("process json process error, the exception is : " + e.getMessage());
            return DEFAULT_JSON_VALUE;
        }
    }

    /**
     * convert Object bean to json String
     *
     * @param data T
     * @param <T>  <T>
     * @return String
     */
    public static <T> String convertObjectBeanToJsonString(T data) {
        log.warn("process convert object bean to json string");
        ResultBean nullableResultBean = getNullableResultBean(data);
        try {
            return OBJECT_MAPPER.writeValueAsString(nullableResultBean);
        } catch (JsonProcessingException e) {
            log.error("process json process error, the exception is : " + e.getMessage());
            return DEFAULT_JSON_VALUE;
        }
    }

    /**
     * convert Object to String Pretty
     *
     * @param resultBean ResultBean<T>
     * @param <T>        <T>
     * @return String
     */
    public static <T> String convertObjectToStringPretty(ResultBean<T> resultBean) {
        log.warn("process Object to String Pretty");
        resultBean = Optional.ofNullable(resultBean).orElseGet(JsonUtil::getNullableResultBean);
        try {
            return OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(resultBean);
        } catch (JsonProcessingException e) {
            log.error("process json process error, the exception is : " + e.getMessage());
            return DEFAULT_JSON_VALUE;
        }
    }

    /**
     * convert Object to String Pretty
     *
     * @param data T
     * @param <T>  <T>
     * @return String
     */
    public static <T> String convertObjectToStringPretty(T data) {
        log.warn("process Object to String Pretty");
        ResultBean nullableResultBean = getNullableResultBean(data);
        try {
            return OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(nullableResultBean);
        } catch (JsonProcessingException e) {
            log.error("process json process error, the exception is : " + e.getMessage());
            return DEFAULT_JSON_VALUE;
        }
    }

    /**
     * convert Json String to Object
     *
     * @param jsonString String
     * @param clazz      Class<T>
     * @param <T>        <T>
     * @return T
     */
    public static <T> T convertStringToObject(String jsonString, Class<T> clazz) {
        log.warn("process String to Object Bean");
        if (isNull(jsonString, clazz)) {
            return null;
        }
        try {
            return Objects.equals(String.class, clazz) ? (T) jsonString : OBJECT_MAPPER.readValue(jsonString, clazz);
        } catch (JsonProcessingException e) {
            log.error("process json process error, the exception is : " + e.getMessage());
            return (T) DEFAULT_JSON_VALUE;
        }
    }

    /**
     * convert Json String to Object
     *
     * @param jsonString    String
     * @param typeReference TypeReference<T>
     * @param <T>           <T>
     * @return T
     */
    public static <T> T convertStringToObject(String jsonString, TypeReference<T> typeReference) {
        log.warn("process String to Object Bean");
        if (isNull(jsonString, typeReference)) {
            return null;
        }
        try {
            return Objects.equals(String.class, typeReference) ? (T) jsonString : OBJECT_MAPPER.readValue(jsonString, typeReference);
        } catch (JsonProcessingException e) {
            log.error("process json process error, the exception is : " + e.getMessage());
            return (T) DEFAULT_JSON_VALUE;
        }
    }

    /**
     * convert Json String to Object
     *
     * @param jsonString      String
     * @param collectionClass Class<?>
     * @param elementClasses  Class<?>...
     * @param <T>             <T>
     * @return T
     */
    public static <T> T convertStringToObject(String jsonString, Class<?> collectionClass, Class<?>... elementClasses) {
        JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(collectionClass, elementClasses);
        try {
            return OBJECT_MAPPER.readValue(jsonString, javaType);
        } catch (JsonProcessingException e) {
            log.error("process json process error, the exception is : " + e.getMessage());
            return (T) DEFAULT_JSON_VALUE;
        }
    }

    /**
     * JsonBuilder
     */
    public static class JsonBuilder {
        private final Map<String, Object> builderMap = new HashMap<>(INITIAL_CAPACITY);

        public JsonBuilder() {
        }

        public JsonUtil.JsonBuilder put(String key, Object value) {
            builderMap.put(key, value);
            return this;
        }

        public String builder() {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.writeValueAsString(this.builderMap);
            } catch (JsonProcessingException e) {
                log.error("json process error, the exception is : " + e.getMessage(), e);
            }
            return DEFAULT_JSON_VALUE;
        }

    }

    /**
     * get null able default result bean
     *
     * @return ResultBean
     */
    private static ResultBean getNullableResultBean() {
        return new ResultBean<>(ResultInfo.FAIL);
    }

    /**
     * get null able default result bean
     *
     * @param data T
     * @param <T>  <T>
     * @return ResultBean
     */
    private static <T> ResultBean getNullableResultBean(T data) {
        return new ResultBean<>(Objects.equals(null, data) ? ResultInfo.FAIL : ResultInfo.SUCCESS, Objects.equals(null, data) ? "" : data);
    }

    /**
     * judgement is null
     *
     * @param jsonString String
     * @param objects    Object...
     * @param <T>        <T>
     * @return boolean
     */
    private static <T> boolean isNull(String jsonString, Object... objects) {
        return StringUtils.isBlank(jsonString) || objects == null;
    }
}

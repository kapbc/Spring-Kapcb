package com.kapcb.ccc.common.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kapcb.ccc.common.result.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

/**
 * <a>Title: ConvertJsonFromApi </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/1 22:37
 */
public class ConvertJsonFromApi {

    private static final Logger logger = org.apache.log4j.Logger.getLogger(ConvertJsonFromApi.class);

    private ConvertJsonFromApi() {
    }

    /**
     * Convert Object Result Bean To Json String
     *
     * @param result Result<T>
     * @param <T>    T
     * @return String
     */
    public static <T> String convertObjectToJsonByTryCatch(Result<T> result) {
        ObjectMapper objectMapper = new ObjectMapper();
        String convertResult = null;
        try {
            convertResult = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
        } catch (JsonProcessingException e) {
            logger.error("Convert Json To String By Try Catch Error ::: " + e.getMessage(), e);
        }
        return convertResult;
    }

    /**
     * Convert Json String To Object Bean
     *
     * @param jsonString String
     * @param data       T
     * @param <T>        T
     * @return T
     */
    public static <T> Result<T> convertStringToObjectByTryCatch(String jsonString, T data) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_DEFAULT);
        Result<T> convertResult = new Result(data);
        try {
            convertResult = objectMapper.readValue(jsonString, convertResult.getClass());
        } catch (JsonProcessingException e) {
            logger.error("Convert String To Object By Try Catch Error ::: " + e.getMessage(), e);
        }
        return convertResult;
    }
}

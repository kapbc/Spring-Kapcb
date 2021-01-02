package com.kapcb.ccc.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kapcb.ccc.dto.Result;
import lombok.extern.slf4j.Slf4j;

/**
 * <a>Title: ResultConvertUtil </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/2 21:58
 */
@Slf4j
public class ResultConvertUtil {

    private ResultConvertUtil() {
    }

    public static  <T> String convertObjectToJsonString(Result<T> result) {
        ObjectMapper objectMapper = new ObjectMapper();
        String convertResult = null;
        try {
            convertResult = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
        } catch (JsonProcessingException e) {
            log.error("Json Processing Exception ::: " + e.getMessage(), e);
        }
        return convertResult;
    }
}

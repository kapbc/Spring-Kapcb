package com.kapcb.ccc.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kapcb.ccc.common.bean.ResultStatusInfo;
import com.kapcb.ccc.common.result.Result;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * <a>Title: JsonUtil </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/7-11:11
 */
@Slf4j
public class JsonUtil {

    private JsonUtil() {
    }

    public static <T> String convertBeanToJsonString(Result<T> result) {
        ObjectMapper objectMapper = new ObjectMapper();
        String convertResult = null;

        result = Objects.equals(null, result) ? new Result<>(ResultStatusInfo.FAIL) : result;
        try {
            convertResult = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
        } catch (JsonProcessingException jsonProcessingException) {
            log.error("Json Processing Error, Exception is ::: " + jsonProcessingException.getMessage());
        }
        return convertResult;
    }

}

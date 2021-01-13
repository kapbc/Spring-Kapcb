package com.kapcb.ccc.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kapcb.ccc.common.bean.Result;
import com.kapcb.ccc.common.constants.ResultInfo;
import lombok.SneakyThrows;

import java.util.Objects;

/**
 * <a>Title: JsonUtil </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/13 21:15
 */
public class JsonUtil {

    private JsonUtil() {
    }

    @SneakyThrows(JsonProcessingException.class)
    public static <T> String convertObjectToJsonString(Result<T> result) {
        ObjectMapper objectMapper = new ObjectMapper();
        result = Objects.equals(null, result) ? new Result<>(ResultInfo.FAIL) : result;
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
    }
}

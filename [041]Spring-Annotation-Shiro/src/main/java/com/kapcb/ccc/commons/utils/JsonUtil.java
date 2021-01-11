package com.kapcb.ccc.commons.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kapcb.ccc.commons.bean.ResultInfo;
import com.kapcb.ccc.commons.dto.Result;
import lombok.SneakyThrows;

import java.util.Objects;

/**
 * <a>Title: JsonUtils </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/11 22:05
 */
public class JsonUtil {

    private JsonUtil() {
    }

    @SneakyThrows(JsonProcessingException.class)
    public static <T> String convertObjectBeanToJsonString(Result<T> result) {
        ObjectMapper objectMapper = new ObjectMapper();
        result = Objects.equals(result, null) ? new Result<>(ResultInfo.FAIL) : result;
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
    }

}

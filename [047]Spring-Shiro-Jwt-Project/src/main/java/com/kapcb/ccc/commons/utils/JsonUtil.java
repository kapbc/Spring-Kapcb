package com.kapcb.ccc.commons.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kapcb.ccc.commons.constants.ResultInfo;
import com.kapcb.ccc.commons.domain.Result;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * <a>Title: JsonUtil </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/21-9:02
 */
@Slf4j
public class JsonUtil {

    private JsonUtil() {
    }

    @SneakyThrows(JsonProcessingException.class)
    public static <T> String convertToJsonString(Result<T> result) {
        result = Objects.equals(null, result) ? new Result<>(ResultInfo.FAIL) : result;
        ObjectMapper objectMapper = new ObjectMapper();
        log.warn("process convert object bean to json string");
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
    }
}

package com.kapcb.ccc.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kapcb.ccc.commons.bean.Result;
import com.kapcb.ccc.commons.bean.ResultInfo;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * <a>Title: JsonUtil </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/17 20:45
 */
@Slf4j
public class JsonUtil {

    @SneakyThrows(JsonProcessingException.class)
    public <T> String convertBeanToString(Result<T> result) {
        result = Objects.equals(null, result) ? new Result<>(ResultInfo.FAIL) : result;
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
    }
}

package com.kapcb.ccc.commons.utils.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kapcb.ccc.commons.constant.ResultInfo;
import com.kapcb.ccc.commons.domain.Result;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * <a>Title: JsonUtil </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/21 22:54
 */
@Slf4j
public class JsonUtil {

    private JsonUtil() {
    }

    @SneakyThrows(JsonProcessingException.class)
    public static <T> String convertResultToJsonString(Result<T> result) {
        ObjectMapper objectMapper = new ObjectMapper();
        result = result == null ? new Result<>(ResultInfo.FAIL) : result;
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
        log.info("the convert json string is : " + jsonString);
        return jsonString;
    }
}

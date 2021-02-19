package com.kapcb.ccc.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kapcb.ccc.common.constants.ResultInfo;
import com.kapcb.ccc.common.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * <a>Title: JsonUtil </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/6 21:46
 */
@Slf4j
public class JsonUtil {

    private static final String RETURN_VALUE_NO_DATA = "No Data To Convert Please Check!";

    private JsonUtil() {
    }

    /**
     * Convert Object Bean To Json Object
     *
     * @param result Result<T>
     * @param <T>    T
     * @return String
     */
    public static <T> String convertResultToJsonForApi(Result<T> result) {
        ObjectMapper objectMapper = new ObjectMapper();
        String convertResult = null;
        try {
            result = Objects.equals(null, result) ? new Result<>(ResultInfo.NO_DATA_TO_CONVERT) : result;
            convertResult = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
        } catch (JsonProcessingException e) {
            log.error("Convert Json To String For Api error ::: " + e.getMessage());
        }
        return convertResult;
    }
}
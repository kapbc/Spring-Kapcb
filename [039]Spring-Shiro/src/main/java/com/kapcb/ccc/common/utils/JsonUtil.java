package com.kapcb.ccc.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kapcb.ccc.common.bean.ResultBean;
import com.kapcb.ccc.common.dto.ResultInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * <a>Title: JsonUtil </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/8 21:55
 */
@Slf4j
public class JsonUtil {

    private JsonUtil() {
    }

    public static <T> String convertObjectBeanToJsonString(ResultBean<T> resultBean) {
        ObjectMapper objectMapper = new ObjectMapper();
        resultBean = Objects.equals(null, resultBean) ? new ResultBean<>(ResultInfo.FAIL) : resultBean;
        String convertResult = null;
        try {
            convertResult = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(resultBean);
        } catch (JsonProcessingException e) {
            log.error("convert object bean to json string error : " + e.getMessage(), e);
        }
        return convertResult;
    }
}

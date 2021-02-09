package com.kapcb.ccc.commons.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * <a>Title: JsonUtil </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/8 17:51
 */
@Slf4j
public class JsonUtil {

    private static final String DEFAULT_RETURN_JSON_STRING = "{}";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.configure(JsonParser.Feature.);
        OBJECT_MAPPER.configure();
        OBJECT_MAPPER.configure();
        OBJECT_MAPPER.configure();
    }

    public static class Builder {

        private final Map<String, Object> jsonMap = new HashMap<>(16);

        public Builder() {
        }

        public JsonUtil.Builder put(String key, Object value) {
            jsonMap.put(key, value);
            return this;
        }

        public String build() {
            try {
                return OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(jsonMap);
            } catch (JsonProcessingException e) {
                log.error("json process error, the exception is : " + e.getMessage();
                return DEFAULT_RETURN_JSON_STRING;
            }
        }
    }
}

package com.kapcb.ccc.common.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kapcb.ccc.common.Result;
import org.apache.log4j.Logger;


/**
 * <a>Title: ConvertJsonFromApi </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/1 22:37
 */
public class ConvertJsonFromApi {

    private static final Logger logger = org.apache.log4j.Logger.getLogger(ConvertJsonFromApi.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public <T> String convertJsonByTryCatch(Result<T> result) {
        try {
            OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(result);
        } catch (JsonProcessingException e) {
            logger.error("Convert Json To String By Try Catch Error ::: " + e.getMessage());
        }
    }
}

package com.kapcb.ccc.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <a>Title: StringToDateConverter </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/14 15:47
 */
public class StringToDateConverter implements Converter<String, Date> {

    private static final Logger log = LoggerFactory.getLogger(StringToDateConverter.class);

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date convert(String source) {
        log.warn("begin to process the convert");
        try {
            if (StringUtils.isEmpty(source)) {
                throw new NullPointerException("请输入待转换日期");
            }
            Date date = DATE_FORMAT.parse(source);
            return date;
        } catch (Exception e) {
            throw new RuntimeException("输入日期有误");
        }
    }
}

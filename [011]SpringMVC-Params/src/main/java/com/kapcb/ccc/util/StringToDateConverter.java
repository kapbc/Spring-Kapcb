package com.kapcb.ccc.util;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <a>Title:StringToDateConverter</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 * <p>
 * 自定义类型转换器
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/8 12:25
 */
public class StringToDateConverter implements Converter<String, Date> {

    /**
     * 用于把 String 类型转成日期类型
     *
     * @param source source
     * @return Date
     */
    @Override
    public Date convert(String source) {
        DateFormat format = null;

        try {
            if (StringUtils.isEmpty(source)) {
                throw new NullPointerException("请输入待转换日期");
            }
            format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(source);
            return date;
        } catch (Exception e) {
            throw new RuntimeException("输入日期有误");
        }
    }
}

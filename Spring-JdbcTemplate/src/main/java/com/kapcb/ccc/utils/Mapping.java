package com.kapcb.ccc.utils;


import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <a>Title: JdbcRowMapper </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/28-13:57
 */
public class JdbcRowMapper {

    private static final Logger logger = Logger.getLogger(JdbcRowMapper.class);

    private JdbcRowMapper() {
    }

    public static <T> T getResultMapping(ResultSet resultSet, Class<? extends T> clazz) {
        logger.warn("---Come into the getResultMapping---");
        T bean = null;
        try {
            bean = clazz.getConstructor().newInstance();
            Field[] declaredFields = clazz.getDeclaredFields();
            String annotationName = "";
            for (Field field : Objects.requireNonNull(declaredFields)) {
                Annotation[] annotations = field.getAnnotations();
                for (Annotation annotation : Objects.requireNonNull(annotations)) {
                    if (annotation instanceof Column) {
                        Column column = (Column) annotation;
                        annotationName = column.name();
                        logger.warn("annotationName ::: " + annotationName);
                    }
                }
                String fieldName = field.getName();
                String fieldType = field.getType().getSimpleName();
                String setMethodName = parseSetMethodName(fieldName);
                Method setMethod = clazz.getMethod(Objects.requireNonNull(setMethodName), field.getType());
                logger.warn("--------------------------");
                logger.warn("fieldName ::: " + fieldName);
                logger.warn("fieldType ::: " + fieldType);
                logger.warn("setMethodName ::: " + setMethodName);
                logger.warn("--------------------------");
                setValue(Objects.requireNonNull(fieldType), setMethod, bean, resultSet, annotationName);
            }
            logger.warn("---getResultMapping process success---");
            return bean;
        } catch (Exception e) {
            logger.error("getResultMapping error ::: " + e.getMessage(), e);
            return null;
        }
    }

    public static <T> List<T> getResultMappingForList(ResultSet resultSet, Class<? extends T> clazz) {
        logger.warn("---Come into getResultMappingForList---");
        List<T> result = new ArrayList<>();
        T bean = null;
        try {
            do {
                bean = Objects.requireNonNull(clazz).newInstance();
                Field[] declaredFields = clazz.getDeclaredFields();
                String annotationName = "";
                for (Field field : Objects.requireNonNull(declaredFields)) {
                    Annotation[] annotations = field.getAnnotations();
                    for (Annotation annotation : Objects.requireNonNull(annotations)) {
                        if (annotation instanceof Column) {
                            Column column = (Column) annotation;
                            annotationName = column.name();
                        }
                    }

                    String fieldName = field.getName();
                    String fieldType = field.getType().getSimpleName();
                    String setMethodName = parseSetMethodName(fieldName);
                    Method setMethod = clazz.getMethod(fieldName, field.getType());
                    logger.warn("--------------------------");
                    logger.warn("fieldName ::: " + fieldName);
                    logger.warn("fieldType ::: " + fieldType);
                    logger.warn("setMethodName ::: " + setMethodName);
                    logger.warn("--------------------------");
                    setValue(Objects.requireNonNull(fieldType), setMethod, bean, resultSet, annotationName);
                }
                logger.warn("---getResultMappingForList process success---");
                result.add(bean);
            } while (resultSet.next());
        } catch (Exception e) {
            logger.error("getResultMappingForList error ::: " + e.getMessage(), e);
        }
        return null;
    }

    private static void setValue(String fieldType, Method fieldSetMethod, Object bean, ResultSet resultSet, String name) {
        try {
            switch (fieldType) {
                case "String":
                    fieldSetMethod.invoke(bean, resultSet.getString(name));
                    break;
                case "int":
                case "Integer":
                    fieldSetMethod.invoke(bean, resultSet.getInt(name));
                    break;
                case "long":
                case "Long":
                    fieldSetMethod.invoke(bean, resultSet.getLong(name));
                    break;
                case "float":
                case "double":
                case "Float":
                case "Double":
                    fieldSetMethod.invoke(bean, resultSet.getDouble(name));
                    break;
                case "Boolean":
                    fieldSetMethod.invoke(bean, resultSet.getBoolean(name));
                    break;
                case "LocalDateTime":
                    fieldSetMethod.invoke(bean, resultSet.getTimestamp(name).toLocalDateTime());
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            logger.error("JdbcRowMapper convert data for resultSet error : " + e.getMessage(), e);
        }
    }

    private static String parseSetMethodName(String fieldName) {
        if (fieldName == null || "".equals(fieldName)) {
            return null;
        }
        StringBuilder set = new StringBuilder("set");
        set.append(Character.toUpperCase(fieldName.charAt(0)));
        set.append(fieldName.substring(1));
        System.out.println("set.toString() =============== " + set.toString());
        return set.toString();
    }

    private String parseName(String fieldName) {
        if (StringUtils.isBlank(fieldName)) {
            return null;
        }
        int startIndex = fieldName.charAt(0) == '_' ? 1 : 0;
        StringBuffer setMethod = new StringBuffer("set");
        setMethod.append(fieldName.substring(startIndex, startIndex + 1).toLowerCase()).append(fieldName.substring(startIndex + 1));
        return setMethod.toString();
    }

    private static String toCamelCase(String input) {
        if (StringUtils.isBlank(input)) {
            return null;
        }
        input = input.toLowerCase();
        int len = input.length();
        StringBuilder stringBuilder = new StringBuilder(len);
        boolean upperCase = false;
        for (int i = 0; i < len; i++) {
            char c = input.charAt(i);
            if (c == '_') {
                upperCase = true;
            } else if (upperCase) {
                stringBuilder.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

}

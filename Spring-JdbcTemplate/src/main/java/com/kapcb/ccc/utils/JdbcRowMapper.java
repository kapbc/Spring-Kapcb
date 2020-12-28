package com.kapcb.ccc.utils;

import com.kapcb.ccc.annotation.Column;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * <a>Title: JdbcRowMapper </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/28 - 21:29
 */
public class JdbcRowMapper {

    private static final Logger logger = Logger.getLogger(JdbcRowMapper.class);

    private JdbcRowMapper() {
        if (LazyHold.JDBC_ROW_MAPPER != null) {
            throw new RuntimeException("Unable to create more than one singleton case!");
        }
    }

    public static final JdbcRowMapper getInstance() {
        return LazyHold.JDBC_ROW_MAPPER;
    }

    private static class LazyHold {
        private static final JdbcRowMapper JDBC_ROW_MAPPER = new JdbcRowMapper();
    }

    public static void getResultMap(Class<?> clazz, ResultSet resultSet) {
        String annotationName = "";
        Object bean = null;
        try {
            bean = clazz.newInstance();
            Field[] declaredFields = clazz.getDeclaredFields();
            if (ArrayUtils.isNotEmpty(declaredFields)) {
                for (Field declaredField : declaredFields) {
                    Annotation[] annotations = declaredField.getAnnotations();
                    if (ArrayUtils.isNotEmpty(annotations)) {
                        for (Annotation annotation : annotations) {
                            if (annotation instanceof Column) {
                                Column column = (Column) annotation;
                                annotationName = column.name();
                                logger.warn("annotationName::: " + annotationName);
                            }
                        }
                    }
                    String simpleName = declaredField.getType().getSimpleName();
                    String columnName = declaredField.getName();
                    logger.warn("SimpleName::: " + simpleName);
                    logger.warn("columnName::: " + columnName);
                    String setMethodName = parseSetMethodName(columnName);
                    Method method = clazz.getMethod(Objects.requireNonNull(setMethodName), declaredField.getType());
                    logger.warn("method::: " + method);
                    setValue(bean, method, annotationName, simpleName, resultSet);
                }
            }
        } catch (Exception e) {
            logger.error("getResultMap error::: " + e.getMessage(), e);
        }
    }

    private static void setValue(Object bean, Method method, String annotationName, String simpleName, ResultSet resultSet) throws Exception {
        switch (simpleName) {
            case "String":
                method.invoke(bean, resultSet.getString(annotationName));
                break;
            case "Int":
            case "Integer":
                method.invoke(bean, resultSet.getInt(annotationName));
                break;
            case "Long":
                method.invoke(bean, resultSet.getLong(annotationName));
                break;
            case "Float":
            case "Double":
                method.invoke(bean, resultSet.getDouble(annotationName));
                break;
            case "LocalDataTime":
                method.invoke(bean, resultSet.getTimestamp(annotationName).toLocalDateTime());
                break;
            default:
                break;
        }
    }

    private static String parseSetMethodName(String fieldName) {
        if (StringUtils.isBlank(fieldName)) {
            logger.warn("The FieldName is null!!!!");
            return null;
        }
        StringBuilder set = new StringBuilder("set");
        set.append(Character.toUpperCase(fieldName.charAt(0)));
        set.append(fieldName.substring(1));
        logger.warn("The paresSetMethodName is ::: " + set.toString());
        return set.toString();
    }
}

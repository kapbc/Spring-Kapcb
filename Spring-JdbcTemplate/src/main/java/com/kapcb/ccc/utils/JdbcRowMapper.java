package com.kapcb.ccc.utils;

import com.kapcb.ccc.annotation.Column;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
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
public class JdbcRowMapper<T> implements RowMapper<T> {

    private static final Logger logger = Logger.getLogger(JdbcRowMapper.class);

    private final Class<? extends T> clazz;

    public JdbcRowMapper(Class<? extends T> clazz) {
        this.clazz = clazz;
    }

    @SneakyThrows
    @NonNull
    @Override
    public T mapRow(ResultSet resultSet, int i) throws SQLException {
        logger.warn("---Come Into The JdbcRowMapper mapRow---");
        T bean = null;
        try {
            bean = clazz.getConstructor().newInstance();
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field field : Objects.requireNonNull(declaredFields)) {
                String annotationName = null;
                Annotation[] annotations = field.getAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation instanceof Column) {
                        Column column = (Column) annotation;
                        annotationName = column.name();
                        logger.warn("annotationName ::: " + annotationName);
                    }
                }

                String fieldType = field.getType().getSimpleName();
                logger.warn("fieldType ::: " + fieldType);
                String fieldName = field.getName();
                logger.warn("fieldName ::: " + fieldName);
                String setMethodName = parseSetMethodName(fieldName);
                logger.warn("setMethodName ::: " + setMethodName);
                Method setMethod = clazz.getMethod(fieldName, field.getType());
                logger.warn("setMethod ::: " + setMethodName);
                setValue(bean, setMethod, annotationName, fieldType, resultSet);
                logger.warn("---Process The Data Mapping Convert Success---");
            }
        } catch (InstantiationException e) {
            logger.error("JdbcRowMapper Convert Data Error ::: " + e.getMessage(), e);
        }
        return Objects.equals(bean, null) ? clazz.newInstance() : bean;
    }

    private void setValue(Object bean, Method method, String annotationName, String simpleName, ResultSet resultSet) {
        try {
            if (Objects.equals(null, resultSet.getObject(annotationName))) {
                logger.warn("The Column ::: " + annotationName + " from resultMap is null");
                return;
            }
            switch (simpleName) {
                case "String":
                    method.invoke(bean, resultSet.getString(annotationName));
                    break;
                case "int":
                case "Integer":
                    method.invoke(bean, resultSet.getInt(annotationName));
                    break;
                case "long":
                case "Long":
                    method.invoke(bean, resultSet.getLong(annotationName));
                    break;
                case "float":
                case "double":
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
        } catch (Exception e) {
            logger.error("Convert The Data From ResultMap error ::: " + e.getMessage(), e);
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

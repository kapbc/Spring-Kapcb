package com.kapcb.ccc.utils;

import com.kapcb.ccc.annotation.Column;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <a>Title: MappingUtil </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/28 - 22:56
 */
public class MappingUtil {

    private static final Logger logger = Logger.getLogger(MappingUtil.class);

    private MappingUtil() {
    }

    public static <T, R> T copyProperties(T source, R target, ResultSet resultSet) {
        try {
            Class<?> targetClass = target.getClass();

            @SuppressWarnings("unchecked")
            R bean = (R) targetClass.getConstructor().newInstance();
            Field[] declaredFields = targetClass.getDeclaredFields();
            for (Field field : Objects.requireNonNull(declaredFields)) {
                String annotationName = "";
                Annotation[] annotations = field.getAnnotations();
                for (Annotation annotation : Objects.requireNonNull(annotations)) {
                    if (annotation instanceof Column) {
                        Column column = (Column) annotation;
                        annotationName = column.name();
                    }
                }
                String simpleName = field.getType().getSimpleName();
                String columnName = field.getName();
                logger.warn("SimpleName::: " + simpleName);
                logger.warn("columnName::: " + columnName);
                String setMethodName = parseSetMethodName(columnName);
                Method method = targetClass.getMethod(setMethodName, field.getType());
                setValue(bean, method, annotationName, simpleName, resultSet);

                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                List<String> columnNameList = new ArrayList<>();
                for (int i = 0; i < columnCount; i++) {
                    // 获取值
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    if (Objects.equals(columnLabel, annotationName)) {
                        BeanUtils.copyProperties(bean, columnLabel, annotationName);
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
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

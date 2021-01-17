package com.kapcb.ccc.commons.annotation.realize;

import com.kapcb.ccc.commons.annotation.Nullable;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

/**
 * <a>Title: BeanValidate </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/17 16:50
 */
@Slf4j
public class BeanValidate<T> {

    private Class<? extends T> clazz;

    public BeanValidate(Class<? extends T> clazz) {
        this.clazz = clazz;
    }

    @SneakyThrows(value = {InvocationTargetException.class, IllegalAccessException.class, NoSuchFieldException.class})
    public void validate(T data) {
        verified(data);
    }

    private void verified(T source) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        Field[] declaredFields = clazz.getDeclaredFields();
        if (ArrayUtils.isNotEmpty(declaredFields)) {
            for (Field declaredField : declaredFields) {
                boolean isNullable = false;
                Annotation[] annotations = declaredField.getAnnotations();
                if (ArrayUtils.isNotEmpty(annotations)) {
                    isNullable = Arrays.stream(annotations)
                            .filter(Nullable.class::isInstance)
                            .map(Nullable.class::cast)
                            .anyMatch(Nullable::value);
                }
                if (!isNullable) {
                    continue;
                }
                String fieldName = declaredField.getName();
                String methodName = Objects.requireNonNull(getMethodName(fieldName));

                Method[] methods = clazz.getMethods();
                Method method = Arrays.stream(methods)
                        .filter(s -> Objects.equals(s.getReturnType(), declaredField.getType()))
                        .filter(s -> Objects.equals(s.getName(), methodName))
                        .findAny()
                        .orElseThrow(NoSuchFieldException::new);
                judgement(method, source, clazz.getSimpleName(), fieldName);
            }
        }
    }

    private void judgement(Method method, T source, String simpleName, String fieldName) throws InvocationTargetException, IllegalAccessException {
        if (Objects.equals(null, method.invoke(source))) {
            StringBuilder exceptionMessage = new StringBuilder();
            exceptionMessage.append("The column ").append(fieldName);
            exceptionMessage.append(" of the ").append(simpleName);
            exceptionMessage.append(" Bean is required not null. ");
            exceptionMessage.append("Please get the right arguments injection!").append("\n");
            exceptionMessage.append("Please check the program where the property ' ").append(fieldName);
            exceptionMessage.append(" ' is injected for ").append(simpleName).append(" Bean !");
            throw new IllegalArgumentException(exceptionMessage.toString());
        }
    }

    private String getMethodName(String filedName) {
        if (StringUtils.isBlank(filedName)) {
            log.warn("The filed " + filedName + " is null!");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("get");
        sb.append(Character.toLowerCase(filedName.charAt(0)));
        sb.append(filedName.substring(1));
        log.warn("the get method name is : " + sb.toString());
        return sb.toString();
    }
}

package com.kapcb.ccc.common.utils;

import com.kapcb.ccc.common.annotation.VoMapping;
import com.kapcb.ccc.common.exception.SourceObjectNotExistException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * <a>Title: VoUtil </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/8 22:03
 */
@Slf4j
public class VoUtil<T> {

    private static final String SET_METHOD_PREFIX = "set";

    private Class<? extends T> clazz;

    public VoUtil(Class<? extends T> clazz) {
        this.clazz = clazz;
    }

    @SneakyThrows
    public <T, R> void transfer(T source, R target) throws SourceObjectNotExistException {
        if (Objects.equals(null, source)) {
            log.error(" Source Object is null. Can't get VoMapping result. ");
            throw new SourceObjectNotExistException();
        }
        T bean = null;
        try {
            bean = (T) clazz.newInstance();
            Field[] fields = clazz.getFields();
            if (ArrayUtils.isNotEmpty(fields)) {
                for (Field field : fields) {
                    Annotation[] annotations = field.getAnnotations();
                    String annotationValue = null;
                    if (ArrayUtils.isNotEmpty(annotations)) {
                        for (Annotation annotation : annotations) {
                            if (annotation instanceof VoMapping) {
                                VoMapping voMapping = (VoMapping) annotation;
                                annotationValue = voMapping.value();
                            }
                        }
                    }

                    String fieldType = field.getType().getSimpleName();
                    String fieldName = field.getName();
                    String setMethodName = getSetMethodName(fieldName);
                    Method method = clazz.getMethod(setMethodName, field.getType());

                    // TODO GET VO Mapping
                    // invokeSetter(fieldType, annotationValue, )
                }
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    private String getSetMethodName(String fieldName) {
        if (StringUtils.isBlank(fieldName)) {
            log.error("fileName is null");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(fieldName.charAt(0)));
        sb.append(fieldName.substring(1));
        log.info("set method name is : " + sb.toString());
        return sb.toString();
    }
}

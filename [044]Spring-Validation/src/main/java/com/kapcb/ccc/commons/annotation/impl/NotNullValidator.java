package com.kapcb.ccc.commons.annotation.impl;

import com.kapcb.ccc.commons.annotation.NotNull;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

/**
 * <a>Title: NotNullValidator </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/22 22:24
 */
public class NotNullValidator implements ConstraintValidator<NotNull, Object> {

    @Override
    public void initialize(NotNull constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return !Objects.equals(value, null);
    }
}

package com.kapcb.ccc.commons.annotation;

import com.kapcb.ccc.commons.annotation.impl.NotNullValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <a>Title: NotNull </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/22 22:20
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Constraint(validatedBy = NotNullValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNull {

    String field() default "";

    String message() default "{field.can.not.be.null}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

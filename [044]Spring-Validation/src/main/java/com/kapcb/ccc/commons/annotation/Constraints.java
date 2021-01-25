package com.kapcb.ccc.commons.annotation;

import com.kapcb.ccc.commons.annotation.impl.ConstraintsValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <a>Title: Constraints </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/25-13:13
 */
@Inherited
@Documented
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ConstraintsValidation.class})
public @interface Constraints {

    /**
     * 验证不通过时的提示信息
     *
     * @return String
     */
    String message() default "Kapcb : param value must constrains specified value";

    /**
     * 根据实际需求丁的方法
     *
     * @return String
     */
    String contains() default "";

    /**
     * 约束注解在验证时所属的组别
     *
     * @return Class
     */
    Class<?>[] groups() default {};

    /**
     * 负载
     *
     * @return Class<? extends Payload>[]
     */
    Class<? extends Payload>[] payload() default {};
}

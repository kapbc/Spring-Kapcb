package com.kapcb.ccc.commons.annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <a>Title: Verified </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/24 21:08
 */
@Inherited
@Documented
@Target({ElementType.FIELD, ElementType.TYPE_PARAMETER,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Verified {
}

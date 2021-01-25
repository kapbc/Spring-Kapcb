package com.kapcb.ccc.commons.annotation.impl;

import com.kapcb.ccc.commons.annotation.Constraints;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.Objects;

/**
 * <a>Title: ConstraintsValidator </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 * <p>
 * Constraints注解校验器的实现
 * <p>
 * 验证其需要实现ConstraintValidator<U, V>, 其中 U 为对应的注解类, V 为被该注解标记的字段的类型(或其父类的类型)
 * <p>
 * 当项目启动后, 会(懒加载)创建ConstraintValidator的实例, 在创建实例后会初始化调用{@link ConstraintValidator#initialize(Annotation)}方法
 * 所以, 只有第一次请求的时候会走initialize方法, 后面的请求是不会走initialize方法的。
 * <p>
 * 注:(懒加载)创建ConstraintValidator实例时, 会走缓存, 如果缓存中存在ConstraintValidator, 则直接调用相同的ConstraintValidator实例;
 * 如果缓存中没有, 那么会创建新的ConstraintValidator实例。 由于缓存的key是能唯一定位的, 且ConstraintValidator的实例属性只有在{@link ConstraintValidator#initialize(Annotation)}
 * 方法中才会写, 而在{@link ConstraintValidator#isValid(Object, ConstraintValidatorContext)}中是读。所以不需要担心线程安全问题。
 * <p>
 * 住: 如何创建ConstraintValidator实例, 可见源码
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/25-13:19
 * @see //ConstraintTree#getInitializedConstraintValidator(ValidationContext, ValueContext)
 */
public class ConstraintsValidation implements ConstraintValidator<Constraints, Object> {

    private static final Logger log = LoggerFactory.getLogger(ConstraintsValidation.class);

    /**
     * 错误提示信息
     */
    private String contains;

    /**
     * 初始化方法, 在（懒加载）创建一个当前类实例后，会马上执行此方法
     * 此方法只会执行一次, 即: 创建实例后马上执行
     *
     * @param constraintAnnotation 注解信息模型，可以从该模型中获取注解类中定义的一些信息，如默认值等
     */
    @Override
    public void initialize(Constraints constraintAnnotation) {
        log.info(constraintAnnotation.message());
        this.contains = constraintAnnotation.contains();
    }


    /**
     * 校验方法, 每个需要校验的请求都会走这个方法
     * 此方法可能会并发执行, 需要根据实际情况看是否需要保证线程安全
     *
     * @param value                      被校验的对象
     * @param constraintValidatorContext 上下文
     * @return boolean 是否校验通过
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        if (Objects.equals(null, value)) {
            return false;
        }
        log.info("the value is : " + value);
        if (value instanceof String) {
            String strMessage = (String) value;
            log.info("the strMessage is : " + strMessage);
            return strMessage.contains(contains);
        } else if (value instanceof Integer) {
            log.info("the contains is : " + contains);
            return contains.contains(String.valueOf(value));
        }
        return false;
    }
}

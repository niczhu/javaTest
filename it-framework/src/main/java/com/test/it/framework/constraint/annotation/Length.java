package com.test.it.framework.constraint.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Length {

    int value() default -1;

    /**
     * 最小值
     * @return
     */
    int min() default -1;

    /**
     * 最大值
     * @return
     */
    int max() default -1;

    /**
     * 属性名称
     * @return
     */
    String propName() default "";
}

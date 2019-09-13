package com.test.multiDataSource.util;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSourceType {

    String value() default "master";

}

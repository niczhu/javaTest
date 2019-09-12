package com.test.multiDataSource.util;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSourceType {

    String value() default "master";

}

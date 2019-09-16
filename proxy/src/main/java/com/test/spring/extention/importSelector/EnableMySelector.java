package com.test.spring.extention.importSelector;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({MySelector.class})
public @interface EnableMySelector {
}

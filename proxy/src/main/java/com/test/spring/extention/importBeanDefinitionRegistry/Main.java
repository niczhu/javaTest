package com.test.spring.extention.importBeanDefinitionRegistry;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext(AppConfig.class);
        TestService testService = (TestService) ctxt.getBean("testService");

        testService.test();
    }
}

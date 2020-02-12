package com.test.it.framework.config;

import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

public class ArgumentResolverConfig extends WebMvcConfigurationSupport {

    public ArgumentResolverConfig() {
    }

    /**
     * 清册参数解析器
     *
     * @param argumentResolvers
     */
    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        argumentResolvers.add(XX)
        super.addArgumentResolvers(argumentResolvers);

    }
}

package com.test.it.framework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Configuration
public class ArgumentResolverConfig  {


    public ArgumentResolverConfig() {
    }

    /**
     * 清册参数解析器
     *
     * @param argumentResolvers
     */
//    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        argumentResolvers.add(XX)
//        super.addArgumentResolvers(argumentResolvers);

    }

//    @Override
//    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        super.extendMessageConverters(converters);
//
//        for (HttpMessageConverter<?> converter : converters) {
//            if (converter instanceof StringHttpMessageConverter) {
//                ((StringHttpMessageConverter) converter).setDefaultCharset(StandardCharsets.UTF_8);
//            }
//        }
//    }
}

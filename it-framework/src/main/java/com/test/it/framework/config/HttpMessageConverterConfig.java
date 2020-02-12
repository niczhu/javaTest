package com.test.it.framework.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.test.it.framework.converter.DefaultJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class HttpMessageConverterConfig extends WebMvcConfigurationSupport {

    /**
     * 解决controller中@responseBody返回中文字符串乱码问题
     *
     * @param
     */
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.extendMessageConverters(converters);
        for (HttpMessageConverter<?> converter : converters) {
            if (converter instanceof StringHttpMessageConverter) {
                ((StringHttpMessageConverter) converter).setDefaultCharset(StandardCharsets.UTF_8);
            }
        }
    }

    /**
     * 解决返回json对象中文乱码问题
     *
     * @return
     */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {

        //处理中文乱码问题
        List<MediaType> fastMediaTypeList = new ArrayList<MediaType>();
        fastMediaTypeList.add(MediaType.APPLICATION_JSON_UTF8);

        //在convert中添加配置信息
        DefaultJsonHttpMessageConverter defaultJsonHttpMessageConverter = new DefaultJsonHttpMessageConverter();
        defaultJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypeList);

        HttpMessageConverter<?> converter = defaultJsonHttpMessageConverter;

        return new HttpMessageConverters(converter);
    }

}

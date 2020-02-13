package com.test.it.framework.converter;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonHttpMessageConverter extends FastJsonHttpMessageConverter implements InitializingBean {

    public JsonHttpMessageConverter() {
    }

    @Override
    protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        System.out.println("....write internal...");

        Class<?> objClass = obj.getClass();
        boolean assignableFrom = objClass.isAssignableFrom(Throwable.class);

        System.out.println(assignableFrom);
        HttpHeaders headers = outputMessage.getHeaders();

        Map<String,Object> map = new HashMap();
        map.put("code", 0);
        map.put("msg", "success");
        map.put("data", obj);
        super.writeInternal(map, outputMessage);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.addConfig(this.getFastJsonConfig());
    }
    protected void addConfig(FastJsonConfig fastJsonConfig) {
    }
}

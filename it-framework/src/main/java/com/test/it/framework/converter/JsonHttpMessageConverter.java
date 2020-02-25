package com.test.it.framework.converter;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonHttpMessageConverter extends FastJsonHttpMessageConverter {

    public JsonHttpMessageConverter() {
    }

    @Override
    protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

        Map<String,Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "success");
        map.put("result", "0");
        map.put("data", obj);
        super.writeInternal(map, outputMessage);
    }
}

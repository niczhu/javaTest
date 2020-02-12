package com.test.it.framework.converter;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import javafx.fxml.Initializable;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DefaultJsonHttpMessageConverter extends FastJsonHttpMessageConverter  {

    public DefaultJsonHttpMessageConverter() {
    }

    @Override
    protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        System.out.println("....write internal...");

        Map<String,Object> map = new HashMap();
        map.put("code", 0);
        map.put("msg", "success");
        map.put("data", obj);
        super.writeInternal(map, outputMessage);
    }
}

package com.md.it.framework.support.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import springfox.documentation.spring.web.json.Json;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * SwaggerSerializer
 *
 * @author zhuhaipeng6 in 2020/8/5 10:00
 * @version 1.0
 **/
public class SwaggerSerializer implements ObjectSerializer, ObjectDeserializer {

    public final static SwaggerSerializer instance = new SwaggerSerializer();

    public SwaggerSerializer() {
    }

    @Override
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object o) {
        return null;
    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }

    @Override
    public void write(JSONSerializer jsonSerializer, Object object, Object o1, Type type, int i) throws IOException {
        SerializeWriter writer = jsonSerializer.getWriter();
        Json json = (Json) object;
        writer.write(json.value());
    }
}

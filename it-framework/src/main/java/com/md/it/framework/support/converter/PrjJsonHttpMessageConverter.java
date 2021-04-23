package com.md.it.framework.support.converter;

import com.alibaba.fastjson.JSON;
import com.md.it.framework.support.SupportProperties;
import com.md.it.framework.utils.NotExtentWriteInternalUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import springfox.documentation.spring.web.json.Json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JsonHttpMessageConverter
 *
 * @author zhuhaipeng6 in 2020/2/25 22:52
 * @version 1.0
 **/
public class PrjJsonHttpMessageConverter extends com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter {

    private SupportProperties supportProperties;

    private List<String> notExtentPackagePrefix = new ArrayList<>();

    public PrjJsonHttpMessageConverter() {
        initNotWritePackages();
    }

    public PrjJsonHttpMessageConverter(SupportProperties supportProperties) {
        super();
        this.supportProperties = supportProperties;
        initNotWritePackages();

        System.out.println("supportProperties ==> " + supportProperties);
        System.out.println("enable ==> " + supportProperties.isSwaggerEnable());

        addSwaggerSerializer();
    }

    protected void initNotWritePackages() {
        List<String> notExtentWritePackages = NotExtentWriteInternalUtil.getNotExtentWritePackages();
        if (CollectionUtils.isNotEmpty(notExtentWritePackages)) {
            notExtentPackagePrefix = notExtentWritePackages;
        }
    }

    protected void addSwaggerSerializer() {
        if (null != supportProperties && supportProperties.isSwaggerEnable()) {
            this.getFastJsonConfig().getSerializeConfig().put(Json.class, SwaggerSerializer.instance);
        }
    }

    @Override
    protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        System.out.println("obj type  ==> " + JSON.toJSONString(obj.getClass().getName()));
        if (notExtentWrite(obj)) {
            super.writeInternal(obj, outputMessage);
        } else if (null != supportProperties && supportProperties.isSwaggerEnable()) {
            super.writeInternal(obj, outputMessage);
        } else {
            Map<String, Object> map = extentWrite();
            map.put("data", obj);
            super.writeInternal(map, outputMessage);
        }
    }

    protected Map<String, Object> extentWrite() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "success");
        map.put("result", "1");
        return map;
    }

    protected boolean notExtentWrite(Object obj) {
        List<String> notExtentWritePackages = notExtentPackagePrefix;
        if (notExtentWritePackages != null && !notExtentWritePackages.isEmpty()) {
            for (String notPackage : notExtentWritePackages) {
                if (StringUtils.startsWith(obj.getClass().getName(), notPackage)) {
                    return true;
                }
            }
        }
        return false;
    }

}

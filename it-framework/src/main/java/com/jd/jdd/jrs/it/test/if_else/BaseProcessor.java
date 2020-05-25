package com.jd.jdd.jrs.it.test.if_else;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * BaseService
 *
 * @author zhuhaipeng6 in 2020/4/11 15:22
 * @version 1.0
 **/
@Component
public class BaseProcessor {
    private static Map<String, Processor> allProcessor = new HashMap<>();
    private Map<String, Processor> postProcessor = new HashMap<>();
    private String type;

    @PostConstruct
    public void init() {
        final String A = "a";
        final String B = "b";
        postProcessor.put(A, new AProcessor());
        postProcessor.put(B, new BProcessor());
    }

    static {
        final String A = "a";
        final String B = "b";
        allProcessor.put(A, new AProcessor());
        allProcessor.put(B, new BProcessor());
    }

    public BaseProcessor() {
    }

    public BaseProcessor(String type) {
        this.type = type;
    }

    public void invoke() {
        Processor aClass = allProcessor.get(this.type);
        aClass.execute();
    }

    public void postInvoke(String tyep) {
        Processor processor = postProcessor.get(tyep);
        processor.execute();
    }

}

package com.test.springEvent.springEvent;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

        MyPublish myPublish = (MyPublish) ctx.getBean("myPublish");
        myPublish.publishEvent(new MyEvent("测试"));
    }
}

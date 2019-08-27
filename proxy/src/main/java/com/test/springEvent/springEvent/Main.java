package com.test.springEvent.springEvent;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

        // 法一
        ctx.publishEvent(new MyEvent("测试"));

        //　法二
//        MyPublish myPublish = (MyPublish) ctx.getBean("myPublish");
//        myPublish.publishEvent(new MyEvent("测试"));
    }
}

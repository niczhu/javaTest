package com.test.springEvent.springEvent;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanFactory;
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

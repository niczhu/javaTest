package com.test.spring.extention.importSelector;

import com.mysql.jdbc.Driver;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ((TestSelect) ctx.getBean("testSelect")).test();

        System.out.println("=======================");
//        DefaultAdvisorAutoProxyCreator
        Thread thread = new Thread();

    }
}

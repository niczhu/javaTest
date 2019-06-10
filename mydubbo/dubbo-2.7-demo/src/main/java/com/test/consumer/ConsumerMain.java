package com.test.consumer;

import com.test.api.HelloServie;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ct = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        ct.start();

        HelloServie helloServie = ct.getBean("helloService",HelloServie.class);

        String t = helloServie.sayHello("hello service");

        System.out.println(t);

    }
}

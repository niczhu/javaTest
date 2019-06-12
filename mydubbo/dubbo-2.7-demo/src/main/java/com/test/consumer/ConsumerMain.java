package com.test.consumer;

import com.test.api.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ConsumerMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ct = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        ct.start();

        HelloService helloServie = ct.getBean("helloService", HelloService.class);

        HelloService test = ct.getBean("testService",HelloService.class);

        String t = helloServie.sayHello("hello services ==");

        System.out.println(t);

        System.out.println(test.sayHello("test services=="));

    }
}

package com.test.consumer;

import com.test.api.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ConsumerMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ct = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        ct.start();

        HelloService helloServie = ct.getBean("helloService", HelloService.class);

        for (int i = 0; i < 10; i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String t = helloServie.sayHello(" count==>"+i);

            System.out.println(t);
        }

    }

}

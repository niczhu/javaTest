package com.test.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ProviderMain {

    public static void main(String[] args) {
        /**
         * dubbo-service.xml提供所有的服务接口
         * dubbo-service-config.xml 为dubbo-service的配置类，配置注册与应用
         *
         * dubbo-service.xml + dubbo-service-config.xml = dubbo-provider.xml
         *
         */
        ClassPathXmlApplicationContext ct = new ClassPathXmlApplicationContext(new String[]{"dubbo-service.xml","dubbo-service-config.xml"});
        ct.start();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

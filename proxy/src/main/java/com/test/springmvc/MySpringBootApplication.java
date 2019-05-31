package com.test.springmvc;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class MySpringBootApplication {

    /**
     * 模拟spring boot 启动tomcat 及加载servlet等流程
     */
    public static void run(){
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(9080);
        // TODO:
        // 此处可以设置tomcat加载java code 或webapp等内容

        try {

//            tomcat.addWebapp()
            System.out.println("=====my tomcat run =====");
            tomcat.start();

        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }

}

package com.test.springmvc;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResource;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

public class MySpringBootApplication {

    /**
     * 模拟spring boot 启动tomcat 及加载servlet等流程
     */
    public static void run(){
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(9080);
        // TODO:
        // 此处可以设置tomcat加载java code 或webapp等内容

//        String sourcePath = MySpringBootApplication.class.getResource("/").getPath();

        //告訴tomcat你的源碼在哪裏
//        Context ctx = tomcat.addWebapp("/",new File("src/main/").getAbsolutePath());
//        WebResourceRoot resources = new StandardRoot(ctx);
//        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes", sourcePath, "/"));
//
//        ctx.setResources(resources);

        try {
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }

}

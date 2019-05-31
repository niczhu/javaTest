package com.test.springmvc;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 *
 */

@HandlesTypes(TestHandle.class)
public class MyServletContainerInitializer implements ServletContainerInitializer {

    /**
     * 此类为自定义servletContainer类，被tomcat自动扫描加入到容器的方式是
     * 在MATE-INFO/services/javax.servlet.ServletContainerInitializer文件中
     * 添加全路径名： com.test.springmvc.MyServletContainerInitializer
     *
     * @param c
     * @param ctx
     * @throws ServletException
     */
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("=====myservlet container initializer===");
        System.out.println("------------"+c+"------------");
    }
}

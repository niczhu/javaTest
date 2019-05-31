package com.test.springmvc;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 初始化web工程 servlet
 */
public class MyWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {

        System.out.println("=========mywebapplicationinitializer===== ");

        /**
         * 初始化spring web context
         */
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();


        /**
         * 初始化dispatcherServlet
         * 向servlet中注入spring context
         *
         * 设置servlet mapping
         * 设置servlet启动时加载
         *
         */
        DispatcherServlet dispatcherServlet = new DispatcherServlet(ctx);
        ServletRegistration.Dynamic registration = servletContext.addServlet("XXX",dispatcherServlet);
        registration.addMapping("/");
        registration.setLoadOnStartup(1);


    }
}

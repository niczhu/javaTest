package com.test.springmvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * pom.xml中修改<packaging>war</packaging> 启动web工程
 *
 */
@Configuration
@ComponentScan("com.test.springmvc")
public class AppConfig implements WebMvcConfigurer {



    /**
     * 视图模板解析
     *
     * 等同于InternalResourceViewResolver配置
     * @param registry
     */

//    @Bean
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//    }

    /**
     * 视图模板解析
     * @return
     */
//    @Bean
//    public InternalResourceViewResolver internalResourceViewResolver(){
//        System.out.println("========加载视图解析模板======");
//
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/");
//        resolver.setSuffix("");
//        return resolver;
//    }
}

package com.md.it.framework.config;

import com.md.it.framework.support.PrjWebMvcConfigSupport;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 * MyWebMvcConfig
 *
 * @author zhuhaipeng6 in 2020/4/11 20:58
 * @version 1.0
 **/
@Configuration
public class MyWebMvcConfig extends PrjWebMvcConfigSupport {

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}

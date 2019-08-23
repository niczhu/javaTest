package com.test.springaop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 使用注解配置spring 
 * created by zhp on 2019年4月20日
 */

@Configuration
@ComponentScan("com.test.springaop")
@EnableAspectJAutoProxy
public class AppConfig {

}

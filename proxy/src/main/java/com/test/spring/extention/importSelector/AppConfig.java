package com.test.spring.extention.importSelector;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.test.spring.extention.importSelector")
@EnableMySelector
public class AppConfig {


}

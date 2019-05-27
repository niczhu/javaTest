package com.test.importSelector;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.test.factoryBean")
@EnableMySelector
public class AppConfig {


}

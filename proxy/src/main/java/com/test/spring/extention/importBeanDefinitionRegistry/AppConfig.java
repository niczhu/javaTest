package com.test.spring.extention.importBeanDefinitionRegistry;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MyImportBDRegistry.class)
@ComponentScan("com.test.spring.extention.importBeanDefinitionRegistry")
public class AppConfig {
}

package com.test.importBeanDefinitionRegistry;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MyImportBDRegistry.class)
@ComponentScan("com.test.importBeanDefinitionRegistry")
public class AppConfig {
}

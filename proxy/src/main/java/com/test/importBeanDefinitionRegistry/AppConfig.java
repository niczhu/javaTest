package com.test.importBeanDefinitionRegistry;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MyImportBDRegistry.class)
public class AppConfig {
}

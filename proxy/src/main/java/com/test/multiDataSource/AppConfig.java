package com.test.multiDataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(value = "com.test.multiDataSource")
@ImportResource(locations = {"spring-multi-data-source.xml"})
@MapperScan("com.test.multiDataSource.dao")
public class AppConfig {

}

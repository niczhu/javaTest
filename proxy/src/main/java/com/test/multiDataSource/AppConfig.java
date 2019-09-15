package com.test.multiDataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(value = "com.test.multiDataSource")
//@Import(value = MultiDataSourceConfig.class)
@Import(value=JtaConfig.class)
@MapperScan("com.test.multiDataSource.dao")
@EnableAspectJAutoProxy
public class AppConfig {

}

package com.test.it.framework.config;

import com.test.it.framework.constraint.service.ValidatorService;
import com.test.it.framework.constraint.service.ValidatorServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ValidatorConfig
 *
 * @author zhuhaipeng6 in 2020/2/25 23:12
 * @version 1.0
 **/
@Configuration
public class ValidatorConfig {

    @Bean
    public ValidatorService validatorService(){
        return new ValidatorServiceImpl();
    }
}

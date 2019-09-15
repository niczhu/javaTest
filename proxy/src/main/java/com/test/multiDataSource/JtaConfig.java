package com.test.multiDataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Author zhuhp
 * @Date 2019/9/14
 */
@Configuration
@ImportResource(locations={"spring-jta.xml"})
public class JtaConfig {
}

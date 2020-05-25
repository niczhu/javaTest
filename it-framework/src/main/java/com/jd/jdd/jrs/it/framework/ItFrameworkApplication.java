package com.jd.jdd.jrs.it.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.test")
public class ItFrameworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItFrameworkApplication.class, args);
	}

}

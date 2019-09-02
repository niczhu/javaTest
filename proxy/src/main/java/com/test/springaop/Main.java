package com.test.springaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

	public static void main(String[] s) {
		annotationSpring();
	}
	
	/**
	 * 使用注解启动spring
	 */
	public static void annotationSpring(){
		AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext(AppConfig.class);
		ctxt.getBean(AspectTest.class).test();
	}
	/**
	 * xml配置spring
	 */
	public static void xmlSpring(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:aop-application-context.xml");
		XmlTest test = ctx.getBean(XmlTest.class);
		test.test();
	}
}

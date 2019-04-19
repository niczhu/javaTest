package com.test.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] s) {
		
		xmlTest1();
		

	}
	
	public static void xmlTest1(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:aop-application-context.xml");
		AopTest test = ctx.getBean(AopTest.class);
		test.test();
	}
}

package com.test.aop;

import org.springframework.stereotype.Component;

@Component
public class AspectTest {
	
	public void test(){
		System.out.println(" *** AspectTest -> test *****");
	}
}

package com.test.proxy.javaProxy;

public class TargetImpl implements Target {

	@Override
	public String sayHello(String string) {
		System.out.println("java proxy target clazz impl .. ");
		return "sayHello:" + string;
	}

}

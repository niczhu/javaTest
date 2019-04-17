package com.test.proxy.javaProxy;

public class InvokeClassImpl implements InvokeClazz {

	@Override
	public String sayHello(String string) {
		System.out.println("test sayHello:"+string);
		return "sayHello:" + string;
	}

}

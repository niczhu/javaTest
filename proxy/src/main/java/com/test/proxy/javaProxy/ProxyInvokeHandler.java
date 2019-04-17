package com.test.proxy.javaProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInvokeHandler implements InvocationHandler {

	private Object iTest;

	public ProxyInvokeHandler(Object iTest) {
		this.iTest = iTest;
	}
	
	public Object getProxy(){
		return (Object)Proxy.newProxyInstance(iTest.getClass().getClassLoader(), iTest.getClass().getInterfaces(), this);
	}
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before");
        Object invoke = method.invoke(iTest, args);
        System.out.println("after");
        return invoke;
	}

}

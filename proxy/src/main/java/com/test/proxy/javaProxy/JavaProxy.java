package com.test.proxy.javaProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JavaProxy implements InvocationHandler {

	private Object target;

	public JavaProxy(Object target) {
		this.target = target;
	}
	
	public Object newInstance(){
		return (Object)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}


	/**
	 * 代理方法的增强逻辑
	 */

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("java proxy before");
        Object invoke = method.invoke(target, args);
        System.out.println("java proxy after");
        return invoke;
	}

}

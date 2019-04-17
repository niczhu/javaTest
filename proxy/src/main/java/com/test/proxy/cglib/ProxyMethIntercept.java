package com.test.proxy.cglib;

import java.lang.reflect.Method;
import java.util.Arrays;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ProxyMethIntercept implements MethodInterceptor {
	
	private Enhancer enhancer = new Enhancer();

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy proxy) throws Throwable {
		System.out.println("method interceptor");
		System.out.println("object:"+arg0.getClass().getName() + "  method:"+arg1.getName() + "  object[]:"+Arrays.toString(arg2) +"  proxy:"+proxy.getClass());
		return proxy.invokeSuper(arg0,arg2);
	}
	
	public Object newProxyInstance(Class<?> c){
		
		enhancer.setSuperclass(c);
		enhancer.setCallback(this);
		
		return enhancer.create();
	}

}

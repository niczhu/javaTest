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
		/**
		 * newProxyInstance 解决三个问题：
		 * 1. classloader 检验生成的代理类是否是要代理的目标类，classload把代理类加载到jvm中
		 *
		 * 2. interface  解决在哪里做代理
		 *
		 * 3. this (实现handle的类) 解决代理的具体内容
		 */

		return (Object)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}


	/**
	 * 代理方法的增强逻辑
	 */

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("proxy name =" + proxy.getClass());
		System.out.println("java proxy before");
        Object invoke = method.invoke(target, args);
        System.out.println("java proxy after");
        return invoke;
	}

}

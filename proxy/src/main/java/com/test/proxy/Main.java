package com.test.proxy;

import com.test.proxy.cglib.InterceptorClazz;
import com.test.proxy.cglib.ProxyMethIntercept;
import com.test.proxy.javaProxy.InvokeClassImpl;
import com.test.proxy.javaProxy.InvokeClazz;
import com.test.proxy.javaProxy.ProxyInvokeHandler;

public class Main {
	
	public static void main(String[] ss){
		
		InvokeClazz test = new InvokeClassImpl();
		ProxyInvokeHandler proxyInvoke = new ProxyInvokeHandler(test);
		InvokeClazz iTest = (InvokeClazz)proxyInvoke.getProxy();
		iTest.sayHello("hello world");
		
		System.out.println("-------------------");
		ProxyMethIntercept test2 = new ProxyMethIntercept();
		InterceptorClazz doTest = (InterceptorClazz)test2.newProxyInstance(InterceptorClazz.class);
		doTest.doSth("haha..");
		
		System.out.println("-------------------");
		ProxyMethIntercept test3 = new ProxyMethIntercept();
		InvokeClassImpl testHallo = (InvokeClassImpl)test3.newProxyInstance(InvokeClassImpl.class);
		testHallo.sayHello("say hello....");
	}
	

}

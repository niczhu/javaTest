package com.test.importSelcetor;

import com.test.proxy.cglib.CglibProxy;
import com.test.proxy.cglib.CglibTarget;
import com.test.proxy.javaProxy.JavaProxy;
import com.test.proxy.javaProxy.Target;
import com.test.proxy.javaProxy.TargetImpl;

public class Main {
	
	public static void main(String[] ss){


		// java 动态代理
		javaproxy();

		// cglib动态代理
		System.out.println("-------------------");

		cglibProxy();

	}

	private static void javaproxy(){
		JavaProxy javaProxy = new JavaProxy(new TargetImpl());
		Target proxy = (Target)javaProxy.newInstance();
		proxy.sayHello("java");

	}

	private static  void cglibProxy(){
		CglibProxy test2 = new CglibProxy();
		CglibTarget target = (CglibTarget)test2.newProxyInstance(CglibTarget.class);
		target.doSth("cglib..");

	}
	

}

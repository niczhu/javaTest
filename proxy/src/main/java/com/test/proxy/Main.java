package com.test.proxy;

import com.test.proxy.cglib.CglibTarget;
import com.test.proxy.cglib.CglibProxy;
import com.test.proxy.javaProxy.TargetImpl;
import com.test.proxy.javaProxy.Target;
import com.test.proxy.javaProxy.JavaProxy;
import net.sf.cglib.core.DebuggingClassWriter;
import sun.misc.Launcher;
import sun.misc.ProxyGenerator;
import sun.misc.URLClassPath;

import java.net.URL;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
	
	public static void main(String[] ss){

		//该设置用于输出cglib动态代理产生的类
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:");
		//该设置用于输出jdk动态代理产生的类
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

		// java 动态代理
		javaproxy();

		// cglib动态代理
		System.out.println("-------------------");

		cglibProxy();
		String s1 = new String("222");

		String s2 = new String("222");

		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));

//		ProxyGenerator.generateProxyClass("",null);
		URLClassPath bootstrapClassPath = Launcher.getBootstrapClassPath();
		URL[] urLs = bootstrapClassPath.getURLs();
		for (URL urL : urLs) {
			System.out.println(urL.getPath());
		}

		System.out.println(Thread.currentThread());
		System.out.println(Thread.currentThread().getContextClassLoader());

	}

	public class MyClassLoad extends ClassLoader{

	}

	private static void javaproxy(){
		JavaProxy javaProxy = new JavaProxy(new TargetImpl());
		Target proxy = (Target)javaProxy.newInstance();
		proxy.sayHello("hello world");

	}

	private static  void cglibProxy(){
		CglibProxy test2 = new CglibProxy();
		CglibTarget proxy = (CglibTarget)test2.newProxyInstance(CglibTarget.class);
		proxy.doSth("cglib..");

	}
	

}

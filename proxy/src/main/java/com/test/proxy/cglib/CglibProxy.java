package com.test.proxy.cglib;

import java.lang.reflect.Method;
import java.util.Arrays;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    @Override
    public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy proxy) throws Throwable {
        System.out.println("cglib proxy intercept..");
        System.out.println("intercept method = "+ arg1);
        return proxy.invokeSuper(arg0, arg2);
    }

    public Object newProxyInstance(Class<?> c) {

        enhancer.setSuperclass(c);
        enhancer.setCallback(this);

        return enhancer.create();
    }

}

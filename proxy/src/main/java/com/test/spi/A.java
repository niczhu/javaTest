package com.test.spi;

public class A
{


    public A(){
        Thread.currentThread().setContextClassLoader(new MyClassloader());
    }
}

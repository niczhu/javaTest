package com.test.provider;

import com.test.api.HelloServie;

public class HelloServiceImpl implements HelloServie {
    @Override
    public String sayHello(String name) {
        return "hello "+ name;
    }
}

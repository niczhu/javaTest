package com.test.provider;

import com.test.api.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "service provider sayhello: "+ name;
    }
}

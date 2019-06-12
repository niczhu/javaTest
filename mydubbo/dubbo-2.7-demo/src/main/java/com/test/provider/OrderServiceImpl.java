package com.test.provider;

import com.test.api.HelloService;

public class OrderServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "orderService ==" + name;
    }
}

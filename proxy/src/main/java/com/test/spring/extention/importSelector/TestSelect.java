package com.test.spring.extention.importSelector;

import org.springframework.stereotype.Component;

@Component
public class TestSelect {

    public TestSelect(){
        System.out.println("testSelect struct");
    }

    public void test(){
        System.out.println("TestSEelct test()");
    }
}

package com.test.spring.extention.importBeanDefinitionRegistry;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

@Component
@MapperScan
public class TestService {

    private String name;

    public void test(){
        System.out.println("TestService test() ===");
    }

    public void setName(String name){
        this.name = name;
        System.out.println("===TestService setName()====");
    }

    public String getName(){
        return  this.name;
    }
}

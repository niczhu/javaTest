package com.test.factoryBean;

import org.springframework.stereotype.Component;

@Component
public class TargetBean {
    public TargetBean(){
        System.out.println("targetBean ...");
    }

    public void say(){
        System.out.println("TargetBean --> say() ");
    }
}

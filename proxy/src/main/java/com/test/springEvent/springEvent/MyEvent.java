package com.test.springEvent.springEvent;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

//@Component
public class MyEvent extends ApplicationEvent {


    public MyEvent(Object source) {
        super(source);
        System.out.println(source.getClass().getSimpleName());
    }

    public void eventTest(){
        System.out.println("====MyEvent 发生了变化  ====");
    }

}

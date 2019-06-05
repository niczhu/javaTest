package com.test.springEvent.springEvent;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

//@Component
public class MyEvent extends ApplicationEvent {


    public MyEvent(Object source) {
        super(source);
    }

    public void eventTest(){
        System.out.println("====事件方法 event test() ====");
    }

}

package com.test.springEvent.javaEvent;

import java.util.EventListener;

public class MyListener implements EventListener {

    public MyListener(){

    }

    public void fireMyListener(MyEvent myEvent){
        System.out.println("=========监听器执行fireMylistener===");
        System.out.println("=========eventSource:" + myEvent.getSource() + "  event:"+myEvent);
    }
}

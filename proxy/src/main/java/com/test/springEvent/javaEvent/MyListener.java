package com.test.springEvent.javaEvent;

import java.util.EventListener;

/**
 * 监听器
 *
 * <p>依赖于event</p>
 * <p>被注册在事件源上source</p>
 *
 */
public class MyListener implements EventListener {

    public MyListener(){

    }

    public void fireMyListener(MyEvent myEvent){

        MyEventSource source = ((MyEventSource) myEvent.getSource());

        System.out.println("=========监听器执行fireMylistener===");
        System.out.println(" --set name is-- " + source.getName());

    }
}

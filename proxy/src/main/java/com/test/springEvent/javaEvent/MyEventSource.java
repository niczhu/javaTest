package com.test.springEvent.javaEvent;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 事件源
 *
 */
public class MyEventSource {

    private Set<MyListener> listeners ;

    public MyEventSource(){
        this.listeners = new HashSet<>();
    }

    /**
     * 添加
     */
    public void addListener(MyListener listener){
        this.listeners.add(listener);
    }

    /**
     * 删除
     * @param listener
     */
    public void removeListener(MyListener listener){
        this.listeners.remove(listener);
    }

    public void notifyListener(){
        MyListener listener = null;
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()){
             listener = (MyListener) iterator.next();
             listener.fireMyListener(new MyEvent(this));

        }
    }

}

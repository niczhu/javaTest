package com.test.springEvent.javaEvent;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 事件源
 *
 * <p>依赖监听器</p>
 * <p>监听器被注册到事件源上</p>
 *
 */
public class MyEventSource {

    private Set<MyListener> listeners ;

    private String name;

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

    private void notifyListener(){
        MyListener listener1 = null;
        Iterator iterator = this.listeners.iterator();

        while (iterator.hasNext()){
             listener1 = (MyListener) iterator.next();

             if(listener1!=null){
                 listener1.fireMyListener(new MyEvent(this));
             }

        }

    }

    public void setName(String name){
        this.name = name;
        notifyListener();
    }

    public String getName(){
        return this.name;

    }

}

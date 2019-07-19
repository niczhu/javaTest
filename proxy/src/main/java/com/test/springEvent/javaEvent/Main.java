package com.test.springEvent.javaEvent;

/**
 * java 事件机制demo
 *
 * java g
 *
 */
public class Main {

    public static void main(String[] args) {

        MyEventSource source = new MyEventSource();

        // 注册方法一
//        MyListener myListener = new MyListener();
//        source.addListener(myListener);

        // 注册方法二
        source.addListener(new MyListener(){
            @Override
            public void fireMyListener(MyEvent myEvent) {
                super.fireMyListener(myEvent);
            }
        });

        source.setName(" nick");
    }
}

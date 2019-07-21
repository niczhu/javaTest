package com.test.springEvent.javaEvent;

/**
 * java 事件机制demo
 *
 * java g
 *
 */
public class Main {

    /**
     * 笔记
     *
     * 事件源通过监听器触发事件
     *
     * source --> listener --> event
     *
     * @param args
     */

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

        /**
         * 触发事件
         */
        source.setName(" nick");
    }
}

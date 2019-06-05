package com.test.springEvent.javaEvent;

/**
 * java 事件机制demo
 */
public class JavaMain {

    public static void main(String[] args) {
        MyEventSource source = new MyEventSource();
        MyEvent event = new MyEvent(source);

        MyListener myListener = new MyListener();
        System.out.println("111");
        source.addListener(myListener);


        System.out.println("222");
        // 法二
        source.addListener(new MyListener(){
            @Override
            public void fireMyListener(MyEvent myEvent) {
                super.fireMyListener(myEvent);
                System.out.println("===复写方法===");
            }
        });


    }
}

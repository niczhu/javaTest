package com.test.springEvent;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationEventMulticaster;

import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        /**
         * java 事件驱动/观察者
         *
         * EventObject
         * EventListener
         * Source
         *
         */
        Thread thread = new Thread();
        thread.start();
//        thread.interrupt();
        Thread.currentThread().interrupt();
        System.out.println(thread.interrupted());
        System.out.println(thread.isInterrupted());
        Socket socket = new Socket();

//        thread.interrupt();

        /**
         * spring 事件机制
         * ApplicationEvent
         * ApplicationListener
         * ApplicationEventPublisher
         * ApplicationEventMulticaster
         */
    }
}

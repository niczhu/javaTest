package com.test.threadPool;

import io.netty.util.concurrent.ThreadPerTaskExecutor;

import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

import static javafx.scene.input.KeyCode.K;

public class ThreadDemo{

    public static void main(String[] args) {

        int h;
        Object key = new Object();
        int b;
        b =1; //1
        h=0;  //0

        System.out.println(1&1);
        System.out.println(0&0);
        System.out.println(1|0);
        System.out.println(0|0);

        System.out.println(h=key.hashCode());
        System.out.println(b = h>>>16);
        System.out.println(h ^ b);
        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
        objectObjectConcurrentHashMap.put("","");

//        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);


    }

    public static class ThreadTest extends Thread{
    }

    public static class runnableTest implements Runnable{

        @Override
        public void run() {
            System.out.println("run ...");
        }
    }


}

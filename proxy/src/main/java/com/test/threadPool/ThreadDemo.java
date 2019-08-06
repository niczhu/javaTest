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

public class ThreadDemo extends Thread{

    int i;
    Thread previousThread; //上一个线程

    public ThreadDemo(Thread previousThread, int i) {
        this.previousThread = previousThread;
        this.i = i;
    }

    @Override
    public void run() {
        try {
            //调用上一个线程的join方法，大家可以自己演示的时候可以把这行代码注释掉
            previousThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("num:" + i);
    }

    public static void main(String[] args) {
        Thread previousThread = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            ThreadDemo joinDemo = new ThreadDemo(previousThread, i);
            joinDemo.start();
            previousThread = joinDemo;
        }
    }

}



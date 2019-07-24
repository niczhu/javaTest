package com.test.threadPool;

import io.netty.util.concurrent.ThreadPerTaskExecutor;

import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.concurrent.Future;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo{

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread();
            System.out.println(thread.getName() );
        }
        for (int i = 0; i < 3; i++) {
            runnableTest runnableTest = new runnableTest();
            runnableTest.run();
        }


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

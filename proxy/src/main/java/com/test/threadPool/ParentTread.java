package com.test.threadPool;

public class ParentTread extends Thread {

    @Override
    public void run() {
        super.run();
        System.out.println("parent");
    }
}

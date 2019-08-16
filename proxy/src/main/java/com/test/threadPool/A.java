package com.test.threadPool;

public class A extends  ParentTread{

    public void run(){

        System.out.println("====A 1 run=====");
        for (int i = 0; i < 10; i++) {

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("===A i ="+ i);

        }
        System.out.println("====A 1 end ====");

    }
}

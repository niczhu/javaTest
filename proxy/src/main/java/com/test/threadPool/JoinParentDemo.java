package com.test.threadPool;

import sun.font.TextRecord;

public class JoinParentDemo extends ParentTread {

    public void run(){
        System.out.println("----JoinParentDemo start---");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("JoinParentDemo = " + i);
        }
    }
}

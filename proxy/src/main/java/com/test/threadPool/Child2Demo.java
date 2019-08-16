package com.test.threadPool;

public class Child2Demo extends ParentTread{
    @Override
    public void run() {
        super.run();
        System.out.println("===Child2Demo demo start===");
        for (int i = 0; i < 9000; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Child2Demo + " + i);

        }
    }
}

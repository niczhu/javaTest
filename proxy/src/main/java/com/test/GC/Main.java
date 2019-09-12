package com.test.GC;

import java.nio.ByteBuffer;

public class Main {

    private static final int _1MB = 1024 * 1024;

    private static Object lock = new Object();

    public static void main(String[] args) throws Exception {

        new Thread(()->{
            int j =0;
            while (true){
                j++;
            }
        }).start();

        cpu();
    }

    public static void test() throws Exception {

        for (int i = 0; i < Integer.MAX_VALUE; i++) {

            Thread.sleep(300);

            ByteBuffer byteBuffer2 = ByteBuffer.allocate(_1MB);

            if (i % 3 == 0) {
                ByteBuffer byteBuffer6 = ByteBuffer.allocate(_1MB / 3);

            }

            if (i % 9 == 0) {
                ByteBuffer byteBuffer5 = ByteBuffer.allocate(_1MB / 8);
            }


            byteBuffer2.put(new String("hahah").getBytes());


        }
    }

    public static void cpu() {

        Thread thread = new Thread(()->{
            synchronized (lock){
                for (; ; ) {
                    int i = 0;
                    i++;
                }
            }
        });

        thread.start();

    }
}

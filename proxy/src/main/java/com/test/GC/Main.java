package com.test.GC;

import java.nio.ByteBuffer;

public class Main {

    public static void main(String[] args) {
        Object o = new Object();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.gc();
    }
}

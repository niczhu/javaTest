package com.test.javaIO;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferTest {
    public static void main(String[] args) throws Exception {
        RandomAccessFile file = new RandomAccessFile("d://test.txt","r");
        FileChannel channel = file.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);
        buffer.flip();

        System.out.println("====" + buffer.limit());
        while(buffer.hasRemaining()){
            System.out.println(buffer.get());
        }


    }
}

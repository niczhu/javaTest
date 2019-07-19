package com.test.javaIO.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioClient  {

    public static void main(String[] args) {
        NioClient nioClient = new NioClient();
        try {
//            nioClient.client();
            System.out.println(1<<0);
            System.out.println(1<<2);
            System.out.println(1<<3);
            System.out.println(1<<4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void client() throws Exception{

        SocketChannel socketChannel =SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1",9190));
        socketChannel.configureBlocking(false);

        // buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //sokectChannel循环
        while (true){
            byte[] bytes = new byte[1024];
            System.in.read(bytes);

            buffer.put(bytes);
            buffer.flip();

            socketChannel.write(buffer);
            buffer.clear();

        }

    }

}

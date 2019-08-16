package com.test.javaIO.NIO;

import org.apache.ibatis.annotations.SelectKey;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverChannel=ServerSocketChannel.open();
        serverChannel.socket().bind(new InetSocketAddress(9190));
        serverChannel.configureBlocking(false);

        Selector selector = Selector.open();
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true){

            selector.select(1000);
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()){

                SelectionKey key = iterator.next();
                iterator.remove();

                if (!key.isValid()) {
                    continue;
                }

                if(key.isAcceptable()){
                    System.out.println("acception connection");
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel accept = server.accept();
                    accept.configureBlocking(false);
                    accept.register(selector,SelectionKey.OP_READ);

                }
                else if(key.isReadable()){
                    System.out.println("is readable==");
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

//                    System.out.println("开始接收信息");
                    SocketChannel socketChannel = ((SocketChannel) key.channel());
                    int read = socketChannel.read(byteBuffer);

                    if (-1 == read) {
                        System.out.println("socekt is null + " + socketChannel.toString() +"  => "+read);
                        key.channel().close();
                        key.cancel();
                        return ;
                    }
                    byteBuffer.flip();
                    byte[] bytes = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bytes);

                    System.out.println("NIO Server : " + new String(bytes));

                }
            }


        }



    }
}

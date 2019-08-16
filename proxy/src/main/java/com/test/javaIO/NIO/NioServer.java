package com.test.javaIO.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioServer implements Runnable {

    private Selector selector;
//    private ServerSocketChannel serverchannel;
    private ByteBuffer readBuffer  = ByteBuffer.allocate(900);

    public static void main(String[] args) throws Exception {
        new Thread(new NioServer()).start();
    }

    /**
     * 初始化
     * @throws Exception
     */
    public NioServer(){

        try {
            selector = Selector.open();

            // socketServer
            ServerSocketChannel  serverchannel = ServerSocketChannel.open();
            serverchannel.configureBlocking(false);
            serverchannel.socket().bind(new InetSocketAddress(9190));

            // 注册selector
            serverchannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("Server start >>>>>>>>> port ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true) {
            try {
                // 1.多路复用器监听阻塞，timeout=1s
                selector.select(1000);

                // 2.多路复用器已经选择的结果集
                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                // 3.不停的轮询
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                SelectionKey key = null;

                // 只有iterator中才能使用remove()
                while (iterator.hasNext()) {
                    System.out.println("while selectionKeys");
                    // 4.获取一个选中的key
                    key = iterator.next();

                    // 5.获取后便将其从容器中移除
                    iterator.remove();

                    if (!key.isValid()) {
                        System.out.println("key is unvalid");
                        continue;
                    }

                    dispatch(key);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    /**
     * 分发
     * @param key
     * @throws Exception
     */
    private void dispatch(SelectionKey key) throws Exception {
        // 阻塞状态处理
//        System.out.println("key 的state ,accept= "+ key.isAcceptable() + ",read="+key.isReadable()+" ,write="+key.isWritable() );
        System.out.println("key hashcode ==> "+key.hashCode());
        if (key.isAcceptable()) {

            accept(key);//新链接建立，注册

        } else if (key.isReadable()) {
            System.out.println("可读状态");
            read(key);
        } else if (key.isWritable()) {
            System.out.println("可读状态");
        }
    }


    // 设置阻塞，等待Client请求。在传统IO编程中，用的是ServerSocket和Socket。在NIO中采用的ServerSocketChannel和SocketChannel
    private void accept(SelectionKey selectionKey) {
        try {
            System.out.println("accept ==> 新建立连接");
            // 1.获取通道服务
            ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
            // 2.执行阻塞方法
            SocketChannel client = server.accept();
            // 3.设置服务器通道为非阻塞模式，true为阻塞，false为非阻塞
            client.configureBlocking(false);
            // 4.把通道注册到多路复用器上，并设置读取标识
            client.register(selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 处理
     * @param selectionKey
     * @throws Exception
     */
    private void read(SelectionKey selectionKey) {
        try {
            // 1.清空缓冲区数据
            readBuffer.clear();
            // 2.获取在多路复用器上注册的通道
            SocketChannel client = (SocketChannel) selectionKey.channel();
            // 3.读取数据，返回
            int count = client.read(readBuffer);
            // 4.返回内容为-1 表示没有数据
            if (-1 == count) {
                selectionKey.channel().close();
                selectionKey.cancel();
                return ;
            }
            // 5.有数据则在读取数据前进行复位操作
            readBuffer.flip();
            // 6.根据缓冲区大小创建一个相应大小的bytes数组，用来获取值
            byte[] bytes = new byte[readBuffer.remaining()];
            // 7.接收缓冲区数据
            readBuffer.get(bytes);
            // 8.打印获取到的数据
            System.out.println("NIO Server : " + new String(bytes)); // 不能用bytes.toString()
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

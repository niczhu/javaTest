package com.test.nettyDemo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 事件处理类
 *
 * inbound数据入站
 *
 *  ***********************
 *  使用telnet 模拟客户端输入
 *
 *  1 进入命令环境 cmd
 *   2. telnet localhost 9090
 *   3. 按住 ctrl + 】
 *   4. 输入命令 send helloworld
 *
 *
 *  参考： https://www.cnblogs.com/xujian2014/p/5704316.html
 *  ************************
 *
 * @Author zhuhp
 * @Date 2019/7/21
 */
public class EchoServerHandle extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf buf=(ByteBuf) msg;
        byte[] req=new byte[buf.readableBytes()];
        buf.readBytes(req);
        System.out.println("服务器端接收的消息："+new String(req));
        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}

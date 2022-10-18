package com.example.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.net.InetSocketAddress;

public class HelloClient {
    public HelloClient() throws InterruptedException {
        // 1.启动类
        ChannelFuture future = new Bootstrap()
                // 2.添加EventLoop
                .group(new NioEventLoopGroup())
                // 3.选择客户端 channel 实现
                .channel(NioSocketChannel.class)
                // 4.添加处理器
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override // 再建立连接后被调用
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new LoggingHandler(LogLevel.DEBUG));
                        ch.pipeline().addLast(new StringEncoder());
                    }
                })
                // 5.连接到服务器
                .connect(new InetSocketAddress("localhost", 8080));

        long start = System.currentTimeMillis();

        Channel channel = future.sync().channel();

        long end = System.currentTimeMillis();
        // 上面建立连接是异步执行的，主线程没有同步的话，可能导致向没有连接的channel发送数据
        channel.writeAndFlush("hello, world").sync();//向服务器发送数据
        channel.writeAndFlush("hello, world");//向服务器发送数据

//        future.sync() // 上面建立连接是异步执行的，主线程没有同步的话，可能导致向没有连接的channel发送数据
//                .channel()
    }
}

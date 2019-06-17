package org.bkn.system.config;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

public class ChatServer {
    /**
     * 服务端监听的端口地址
     */
    private static final int portNumber = 7878;
    
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup);
            b.channel(NioServerSocketChannel.class);
            b.childHandler(new ChatServerInitializer());
            // 服务器绑定端口监听
            ChannelFuture channelFuture = b.bind(portNumber).sync();
            channelFuture.addListener(new GenericFutureListener<Future<? super Void>>() {
                @Override
                public void operationComplete(Future<? super Void> future) throws Exception {
                    System.out.println("server start listen at port : " + portNumber);
                }
            });
            // 监听服务器关闭监听,该方法为异步监听,他会阻塞当前线程,不允许服务器退出,知道调用服务器close方法,主线程继续执行
            ChannelFuture channelFutureClose = channelFuture.channel().closeFuture().sync();
            channelFutureClose.addListener(new GenericFutureListener<Future<? super Void>>() {
                @Override
                public void operationComplete(Future<? super Void> future) throws Exception {
                    System.out.println("server will be shutdown ...");
                }
            });
            // 可以简写为
            /* b.bind(portNumber).sync().channel().closeFuture().sync(); */
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}

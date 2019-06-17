package org.bkn.system.config;

import java.net.InetAddress;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class ChatServerOutHandler extends ChannelHandlerAdapter {
    
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        // TODO Auto-generated method stub
        channelInactive(ctx);
    }
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        // TODO Auto-generated method stub
        super.handlerRemoved(ctx);
    }
    
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("RamoteAddress : " + ctx.channel().remoteAddress() + " active !");
        ctx.writeAndFlush( "Welcome to " + InetAddress.getLocalHost().getHostName() + " service!\n");
        channelActive(ctx);
    }
}
package com.lixiangyu.lee.nio.netty.time.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2018-11-14 16:38
 **/
public class TimeClienthandler extends SimpleChannelInboundHandler {

    private int counter;
    private byte[] req;

    public TimeClienthandler () {
        req = ("query time order").getBytes();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("channelActive");
        ByteBuf message = null;
//        for (int i = 0; i< 100;i++) {
//            message = Unpooled.buffer(req.length);
//            message.writeBytes(req);
//            ChannelFuture channelFuture = ctx.writeAndFlush(message);
//            System.out.println(channelFuture.isDone());
//            System.out.println(channelFuture.isSuccess());
//
//        }

        message = Unpooled.buffer(req.length);
        message.writeBytes(req);
        ChannelFuture channelFuture = ctx.writeAndFlush(message);
        System.out.println(channelFuture.isDone());
        System.out.println(channelFuture.isSuccess());


    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        String body = (String) msg;
        System.out.println("the client receive order: " + body);
    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("messageReceived");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable throwable) {
        ctx.close();
    }

}

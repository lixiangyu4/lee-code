package com.lixiangyu.lee.nio.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;


/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2018-11-13 19:23
 **/
public class TimeServerhandler extends ChannelInboundHandlerAdapter {

    private int counter;

    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object msg) throws Exception {
        String body = (String)msg;
        System.out.println("The time server receive order : " + body + " ; the counter is " + ++counter);
        String currenTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString()
                : "BAD ORDER";
        currenTime = currenTime + System.getProperty("line.separator");
        ByteBuf resp = Unpooled.copiedBuffer(currenTime.getBytes());
        channelHandlerContext.writeAndFlush(resp);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        System.out.println("channelReadComplete");
        super.channelReadComplete(channelHandlerContext);
        channelHandlerContext.flush();

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) {

        System.out.println("exceptionCaught");
        if(null != throwable) throwable.printStackTrace();
        if(null != channelHandlerContext) channelHandlerContext.close();

    }

}

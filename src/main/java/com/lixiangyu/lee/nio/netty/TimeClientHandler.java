package com.lixiangyu.lee.nio.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2018-11-13 09:51
 **/
public class TimeClientHandler extends ChannelInboundHandlerAdapter {

    private final static Logger logger = LoggerFactory.getLogger(TimeClientHandler.class);

    private int counter;
    private  byte[] req;

    public TimeClientHandler() {
         req = ("Query time order"+System.getProperty("line.separator")).getBytes();
    }

    @Override
    public void channelActive(ChannelHandlerContext channelHandlerContext) {
        ByteBuf message = null;
        for (int i = 0; i< 100; i++) {
            message = Unpooled.buffer(req.length);
            message.writeBytes(req);
            channelHandlerContext.writeAndFlush(message);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) {
        logger.warn("Unexpected exception from downstream:" + throwable.getMessage());
        channelHandlerContext.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object msg) throws UnsupportedEncodingException {
        String body = (String) msg;
        System.out.println("now is : " + body + "; the counter is : " + ++counter);
    }




}

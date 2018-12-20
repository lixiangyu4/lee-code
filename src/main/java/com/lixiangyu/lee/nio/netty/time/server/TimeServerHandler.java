package com.lixiangyu.lee.nio.netty.time.server;

import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.io.IOException;
import java.util.Arrays;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2018-11-14 16:31
 **/
public class TimeServerHandler extends ChannelHandlerAdapter {

    private int counter;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws IOException {
        ByteBuf byteBuf = (ByteBuf)msg;
        byte[] array;
        int length = byteBuf.readableBytes();
        array = new byte[length];
        byteBuf.getBytes(byteBuf.readerIndex(), array, 0, length);
        System.out.println(Arrays.toString(array));
        Object parse = JSONObject.parse(array);
        System.out.println(parse);
        String body = (String) msg;
        System.out.println("the server receive order: " + body + "; the counter is : " + ++counter);
        String currentime = "query time order" + System.getProperty("line.separator");
        ByteBuf resp = Unpooled.copiedBuffer(currentime.getBytes());
        ChannelFuture channelFuture = ctx.writeAndFlush(resp);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable throwable) {
        ctx.close();
    }

}

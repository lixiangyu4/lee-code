package com.lixiangyu.lee.nio.netty.time.utils;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.msgpack.MessagePack;
import org.msgpack.type.Value;

import java.util.List;

/**
 * @program: member-service
 * @description:
 * @author: lixiangyu
 * @create: 2018-11-14 17:32
 **/
public class MsgpackDecoder extends MessageToMessageDecoder<ByteBuf> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        final byte[] array;
        final int length = msg.readableBytes();
        array = new byte[length];
        msg.getBytes(msg.readerIndex(), array, 0, length);
        MessagePack messagePack = new MessagePack();
        Value read = messagePack.read(array);
        String s = read.toString();
        out.add(messagePack.read(array));
    }
}

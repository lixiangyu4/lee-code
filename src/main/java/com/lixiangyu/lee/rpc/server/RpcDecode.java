package com.lixiangyu.lee.rpc.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @program: leecode
 * @description: rpc解码
 * @author: lixiangyu
 * @create: 2019-01-21 11:18
 **/
public class RpcDecode extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        byte[] bytes = new byte[in.capacity()];
        in.readBytes(bytes);
        out.add(new String(bytes, StandardCharsets.UTF_8));

    }
}

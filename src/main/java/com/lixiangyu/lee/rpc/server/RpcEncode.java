package com.lixiangyu.lee.rpc.server;

import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @program: leecode
 * @description: rpc 编码
 * @author: lixiangyu
 * @create: 2019-01-21 11:19
 **/
public class RpcEncode extends MessageToByteEncoder {
    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        ByteBuf resp = Unpooled.copiedBuffer(JSON.toJSONString(msg).getBytes());
        out.writeBytes(resp);
    }
}

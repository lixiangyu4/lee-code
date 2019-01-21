package com.lixiangyu.lee.rpc.client;

import com.lixiangyu.lee.rpc.api.dto.RpcRequest;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @program: leecode
 * @description: netty客户端 业务逻辑处理器
 * @author: lixiangyu
 * @create: 2019-01-21 14:29
 **/
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    private RpcRequest rpcRequest;

    NettyClientHandler(RpcRequest rpcRequest) {
        this.rpcRequest = rpcRequest;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {



        ctx.fireChannelActive();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ctx.fireChannelRead(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        ctx.fireExceptionCaught(cause);
    }

}

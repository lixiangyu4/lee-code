package com.lixiangyu.lee.rpc.server;

import com.alibaba.fastjson.JSON;
import com.lixiangyu.lee.rpc.api.dto.RpcRequest;
import com.lixiangyu.lee.rpc.api.dto.RpcResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @program: leecode
 * @description: netty 服务器端业务逻辑处理
 * @author: lixiangyu
 * @create: 2019-01-21 11:20
 **/
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    private Map<String, Object> beanMap;

    NettyServerHandler(Map<String, Object> beanMap) {
        this.beanMap = beanMap;
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        RpcRequest rpcRequest = JSON.parseObject((String)msg, RpcRequest.class);

        Object o = beanMap.get(rpcRequest.getClassName());
        final Method method = o.getClass().getMethod(rpcRequest.getMethodName(), rpcRequest.getParamTypes());
        Object invoke = method.invoke(o, rpcRequest.getArgs());
        RpcResponse rpcResponse = new RpcResponse();
        rpcResponse.setResult(invoke);
        ctx.writeAndFlush(rpcResponse);

    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        ctx.fireExceptionCaught(cause);
    }

}

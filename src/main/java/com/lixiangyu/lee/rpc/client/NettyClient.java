package com.lixiangyu.lee.rpc.client;

import com.lixiangyu.lee.rpc.api.dto.RpcRequest;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @program: leecode
 * @description: netty 客户端
 * @author: lixiangyu
 * @create: 2019-01-21 10:25
 **/
public class NettyClient {

    private String address;
    private int port;
    private RpcRequest rpcRequest;

    NettyClient(String address, int port,RpcRequest rpcRequest) {
        this.address = address;
        this.port = port;
        this.rpcRequest = rpcRequest;
    }

    public void link() {

        EventLoopGroup group = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                final ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast(new NettyClientHandler(rpcRequest));
            }
        }).option(ChannelOption.SO_KEEPALIVE, true);
        try {

            final ChannelFuture sync = bootstrap.bind(address, port).sync();

            sync.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }

    }

}

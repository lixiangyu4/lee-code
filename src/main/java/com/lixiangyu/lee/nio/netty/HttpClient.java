package com.lixiangyu.lee.nio.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @program: leecode
 * @description: netty客户端
 * @author: lixiangyu
 * @create: 2018-11-13 09:28
 **/
public class HttpClient {

    public static void main(String[] args) {
        HttpClient httpClient = new HttpClient();
        httpClient.connect(8090, "127.0.0.1");
    }


    public void connect(int port, String host) {
        EventLoopGroup eventExecutors  = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventExecutors).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new TimeClientHandler())
                .addLast(new LineBasedFrameDecoder(1024))
                .addLast(new StringDecoder());
            }
        }).option(ChannelOption.TCP_NODELAY, true);

        ChannelFuture connect = bootstrap.connect(host, port);
        try {
            ChannelFuture sync = connect.sync();
            sync.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            eventExecutors.shutdownGracefully();
        }

    }

}

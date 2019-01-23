package com.lixiangyu.lee.rpc.server;

import com.lixiangyu.lee.rpc.api.RpcService;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.HashMap;
import java.util.Map;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @program: leecode
 * @description: netty 服务器端
 * @author: lixiangyu
 * @create: 2019-01-21 10:24
 **/
public class NettyServer implements ApplicationContextAware {

    private int port;

    private Map<String, Object> beanMap = new HashMap<>(16);

    public NettyServer(int port) {
        this.port = port;
    }


    public void create() {
        EventLoopGroup parentGroup = new NioEventLoopGroup();
        EventLoopGroup childGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(parentGroup, childGroup).channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new RpcDecode());
                        pipeline.addLast(new RpcEncode());
                        pipeline.addLast(new NettyServerHandler(beanMap));
                    }
                }).option(ChannelOption.SO_BACKLOG, 128)
            .childOption(ChannelOption.SO_KEEPALIVE, true);

        try {
            ChannelFuture sync = serverBootstrap.bind(port).sync();

            sync.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            parentGroup.shutdownGracefully();
            childGroup.shutdownGracefully();
        }

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(RpcService.class);
        for (Map.Entry<String, Object> entry : beansWithAnnotation.entrySet()) {
            beanMap.put(entry.getValue().getClass().getName(), entry);
        }

    }
}

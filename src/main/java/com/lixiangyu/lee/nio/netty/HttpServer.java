package com.lixiangyu.lee.nio.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @program: leecode
 * @description: netty服务端
 * @author: lixiangyu
 * @create: 2018-11-11 14:46
 **/
public class HttpServer {


    private final int port;

    public HttpServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        new HttpServer(8080).start();
    }

    public void start() {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {

            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                System.out.println("initChannel " + socketChannel);
                socketChannel.pipeline()
//                        .addLast("decoder", new HttpRequestDecoder())
//                        .addLast("encoder", new HttpResponseEncoder())
//                        .addLast("aggregator", new HttpObjectAggregator(512 * 1024))
                        .addLast(new TimeServerhandler())
                .addLast(new LineBasedFrameDecoder(1024))
                .addLast(new StringDecoder());
                //确定排队的连接数
            }
        }).option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE);

        try {
            //绑定端口，同步等待成功
            ChannelFuture f = serverBootstrap.bind(port).sync();

            //等待服务端监听端口关闭
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //优雅退出，释放线程池资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

}

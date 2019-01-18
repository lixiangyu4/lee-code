//package com.lixiangyu.lee.nio.netty.time.client;
//
//import io.netty.bootstrap.Bootstrap;
//import io.netty.channel.ChannelFuture;
//import io.netty.channel.ChannelInitializer;
//import io.netty.channel.ChannelOption;
//import io.netty.channel.EventLoopGroup;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioSocketChannel;
//import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
//import io.netty.handler.codec.LengthFieldPrepender;
//
///**
// * @program: leecode
// * @description:
// * @author: lixiangyu
// * @create: 2018-11-14 16:35
// **/
//public class TimeClient {
//
//    public static void main(String[] args) {
//        TimeClient timeClient = new TimeClient();
//        timeClient.connect("127.0.0.1", 8080);
//    }
//
//    public void connect(String host, int port) {
//        EventLoopGroup group = new NioEventLoopGroup();
//        try {
//            Bootstrap b = new Bootstrap();
//            b.group(group).channel(NioSocketChannel.class)
//                    .option(ChannelOption.TCP_NODELAY, true)
//                    .handler(new ChannelInitializer<SocketChannel>() {
//                        @Override
//                        protected void initChannel(SocketChannel socketChannel) throws Exception {
//                            socketChannel.pipeline().addLast("frameEncode", new LengthFieldPrepender(2));
////                           array socketChannel.pipeline().addLast("msgpack encoder", new MsgpackEncoder());
//                            socketChannel.pipeline().addLast("frameDecode", new LengthFieldBasedFrameDecoder(1024,0,2,0,2));
////                            socketChannel.pipeline().addLast("msgpack decoder", new MsgpackDecoder());
//                            socketChannel.pipeline().addLast(new TimeClienthandler());
//                        }
//                    });
//            ChannelFuture connect = b.connect(host, port);
//            System.out.println("connect" + connect.isDone());
//            System.out.println("connect" + connect.isSuccess());
//            ChannelFuture sync = connect.sync();
//            sync.channel().closeFuture().sync();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            group.shutdownGracefully();
//        }
//    }
//
//}

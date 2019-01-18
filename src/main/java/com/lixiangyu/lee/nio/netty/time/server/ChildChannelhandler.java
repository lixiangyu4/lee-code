//package com.lixiangyu.lee.nio.netty.time.server;
//
//import io.netty.channel.ChannelInitializer;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
//import io.netty.handler.codec.LengthFieldPrepender;
//
///**
// * @program: leecode
// * @description:
// * @author: lixiangyu
// * @create: 2018-11-14 16:29
// **/
//public class ChildChannelhandler extends ChannelInitializer<SocketChannel> {
//    @Override
//    protected void initChannel(SocketChannel socketChannel) throws Exception {
//        socketChannel.pipeline().addLast("frameEncode", new LengthFieldPrepender(2));
////        socketChannel.pipeline().addLast("msgpack encoder", new MsgpackEncoder());
//        socketChannel.pipeline().addLast("frameDecode", new LengthFieldBasedFrameDecoder(1024,0,2,0,2));
////        socketChannel.pipeline().addLast("msgpack decoder", new MsgpackDecoder());
//        socketChannel.pipeline().addLast(new TimeServerHandler());
//
//    }
//}

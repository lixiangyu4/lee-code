//package com.lixiangyu.lee.nio.netty;
//
//import io.netty.buffer.Unpooled;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.channel.SimpleChannelInboundHandler;
//import io.netty.handler.codec.AsciiString;
//import io.netty.handler.codec.http.*;
//
///**
// * @program: leecode
// * @description: 自定义nio处理接口
// * @author: lixiangyu
// * @create: 2018-11-11 15:12
// **/
//public class HttpHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
//
//    private AsciiString contentType = HttpHeaderValues.TEXT_PLAIN;
//
//    @Override
//    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
//        System.out.println("channelReadComplete");
//        super.channelReadComplete(channelHandlerContext);
//        channelHandlerContext.flush();
//
//    }
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) {
//
//        System.out.println("exceptionCaught");
//        if(null != throwable) throwable.printStackTrace();
//        if(null != channelHandlerContext) channelHandlerContext.close();
//
//    }
//
//    @Override
//    protected void messageReceived(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) throws Exception {
//        System.out.println("class : " + fullHttpRequest.getClass().getName());
//
//        DefaultFullHttpResponse response =
//                new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
//                        HttpResponseStatus.OK,
//                        Unpooled.wrappedBuffer("---------------test---------------".getBytes()));
//        HttpHeaders headers = response.headers();
//        headers.add(HttpHeaderNames.CONTENT_TYPE, contentType  + "; charset=UTF-8");
//        headers.add(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
//        channelHandlerContext.write(response);
//    }
//}

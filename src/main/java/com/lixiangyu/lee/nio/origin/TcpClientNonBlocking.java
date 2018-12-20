package com.lixiangyu.lee.nio.origin;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2018-11-13 12:52
 **/
public class TcpClientNonBlocking {

    public static void main(String[] args) throws IOException, InterruptedException {
        String server = "127.0.0.1";
        byte[] argument = "adasdsdfdsfdfvv".getBytes();
        int serverPort = 8080;

        //创建一个信道，并设置为非堵塞模式
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);

        //向服务端发起连接
        if(!socketChannel.connect(new InetSocketAddress(server, serverPort))) {
            //不断轮训连接状态，直到完成连接
            while (!socketChannel.finishConnect()) {
                TimeUnit.SECONDS.sleep(1000);
                System.out.print(".");
            }
        }
        System.out.print("\n");
        //分别实例化用来读写的缓冲区
        ByteBuffer writeBuf = ByteBuffer.wrap(argument);
        ByteBuffer readBuf  = ByteBuffer.allocate(argument.length);
        //接受到的总字节数
        int totalBytesRcvd = 0;
        //每调一次read()方法接收到的字节数
        int  bytesRcvd;
        //循环执行，直到接收到的字节数与发送的字符串的字节数相等
        while (totalBytesRcvd < argument.length) {
            //如果用来向通道中写数据的缓冲区中还有剩余的字节，则继续将数据写入信道
            if(writeBuf.hasRemaining()) {
                socketChannel.write(writeBuf);
            }
            //如果read（）接收到-1，表明服务端关闭，抛出异常
            if((bytesRcvd = socketChannel.read(readBuf)) == -1)  {
                throw new SocketException("Connection closed prematurely");
            }

            //计算接收到的总字节数
            totalBytesRcvd += bytesRcvd;
            //在等待通信完成的过程中，程序可以执行其他任务，以体现非阻塞IO的异步特性
            //这里为了演示该方法的使用，同样只是一直打印"."
            TimeUnit.MINUTES.sleep(1);
            System.out.print("1.");
        }

        //打印出接收到的数据
        System.out.println("Received: " +  new String(readBuf.array(), 0, totalBytesRcvd));
        //关闭信道
        socketChannel.close();


    }

}

package com.lixiangyu.lee.queue.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2018-12-27 15:23
 **/
public class BrokerServer implements Runnable {


    private static final int SERVER_PORT = 8888;

    private final Socket socket;


    public BrokerServer(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (true)  {
                String str = in.readLine();
                if(str == null) {
                    continue;
                }
                System.out.println("接受到原始数据:" + str);

                if(str.equals("CONSUME")) {
                    String message = Broker.consume();
                    out.println(message);
                    out.flush();
                } else {
                    Broker.produce(str);
                }
                TimeUnit.SECONDS.sleep(3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        while (true) {
            BrokerServer brokerServer = new BrokerServer(serverSocket.accept());
            new Thread(brokerServer).start();
        }
    }



}

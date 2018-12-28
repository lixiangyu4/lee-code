package com.lixiangyu.lee.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2018-12-27 15:45
 **/
public class MqClient {

    public static void produce(String message) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            out.println(message);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String consume() throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            out.println("CONSUME");
            out.flush();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = bufferedReader.readLine();
            return message;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

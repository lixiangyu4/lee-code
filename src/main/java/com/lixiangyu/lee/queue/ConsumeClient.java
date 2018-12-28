package com.lixiangyu.lee.queue;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2018-12-27 15:50
 **/
public class ConsumeClient {

    public static void main(String[] args) throws Exception {
        String consume = MqClient.consume();
        System.out.println(consume);
    }

}

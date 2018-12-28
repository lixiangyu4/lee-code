package com.lixiangyu.lee.queue;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2018-12-27 15:50
 **/
public class ProduceClient {

    public static void main(String[] args) throws Exception {
        MqClient.produce("hello world ");
    }

}

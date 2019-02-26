package com.lixiangyu.lee.queue.demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @program: leecode
 * @description: broker 消息中介
 * @author: lixiangyu
 * @create: 2018-12-27 15:09
 **/
public class Broker {


    private static final int MAX_SIZE = 3;

    private static final BlockingQueue<String> QUEUE = new LinkedBlockingQueue<>(MAX_SIZE);


    public static void produce(String message) {
        if(QUEUE.offer(message)) {
            System.out.println("成功向消息处理中心投递消息：" + message + ", 当前暂存消息数量为 :" + QUEUE.size());
        } else {
            System.out.println("消息处理中心已经达到最大负荷，不能继续放入消息!");
        }
        System.out.println("========================");
    }


    public static String consume() {
        String message = QUEUE.poll();
        if(null != message) {
            System.out.println("已经消费消息 ：" + message + ", 当前暂存消息数量为 :" + QUEUE.size());
        } else {
            System.out.println("消息处理中心已经没有消息可以处理!");
        }

        System.out.println("========================");
        return message;
    }

}

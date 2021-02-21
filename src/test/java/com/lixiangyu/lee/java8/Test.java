package com.lixiangyu.lee.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-01-11 17:55
 **/
public class Test {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("thread begin");
                Thread.sleep(1000000000);
            } catch (InterruptedException e) {
                System.out.println("thread is isInterrupted");
                return ;
            }
            System.out.println("thread-leaving normal");
        });
        thread.start();

        Thread.sleep(100);

        thread.interrupt();
        thread.isInterrupted();
        thread.join();


        System.out.println("main is over");

    }

}

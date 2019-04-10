package com.lixiangyu.lee.utils;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-04-10 14:57
 **/
public class HelloTest {

    public static void main(String[] args) throws InterruptedException {


        long currenTimeMillis = System.currentTimeMillis();

        //模拟1000个线程并发
        CountDownLatchUtil countDownLatchUtil = new CountDownLatchUtil(1000);
        countDownLatchUtil.latch(() -> new HelloServiceImpl().sayHello(currenTimeMillis));


    }

}

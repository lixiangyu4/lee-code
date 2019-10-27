package com.lixiangyu.lee.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-04-10 15:47
 **/
public class CountDownLatchTest {

    static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        countDownLatch.countDown();

    }

}

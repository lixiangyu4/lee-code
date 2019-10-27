package com.lixiangyu.lee.thread.aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-05-14 14:32
 **/
public class ReentrantLockTest {

    private static ReentrantLock lock = new ReentrantLock();


    public static void main(String[] args) {

        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ":开始获取当前锁");
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + ":获取成功");
                }
            }).start();
        }



    }

}

package com.lixiangyu.lee.thread.lock;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-03-07 16:11
 **/
public class LockDemo {

    private static  ReentrantLock lock = new ReentrantLock();


    public static void main(String[] args) {
        lock.lock();
//        Semaphore
        BlockingQueue queue = new LinkedBlockingQueue();
    }
}

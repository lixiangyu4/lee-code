package com.lixiangyu.lee.thread.threadlocal;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.LockSupport;

public class ThreadLocalTest {

    private static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    private static void  print(String str) {
        System.out.println(str + ":" + threadLocal.get());

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest test = new ThreadLocalTest();
        test.lockSupportTest();
    }

    private void threadLocalTest() {
        Thread thread1 = new Thread(() -> {

            threadLocal.set("thread - 1 - value");
            print("thread1");

        });
        thread1.start();

        System.out.println(threadLocal.get());


        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
    }

    private void lockSupportTest() {

        System.out.println("begin park");
        //LockSupport.unpark(Thread.currentThread());
        LockSupport.park();
        System.out.println("end park");
    }

}

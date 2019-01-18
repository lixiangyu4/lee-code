package com.lixiangyu.lee.thread.singleton;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: leecode
 * @description: 线城池
 * @author: lixiangyu
 * @create: 2019-01-08 16:24
 **/
public class ThreadPoolSingleton {


    private static class ThreadPoolSingletonInner {
        private static AtomicInteger atomicInteger = new AtomicInteger();
        private static ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("ThreadPoolSingleton-Thread-"+atomicInteger.incrementAndGet());
                        return thread;
                    }
                });
    }

    public static ThreadPoolExecutor getInstance() {
        return ThreadPoolSingletonInner.threadPoolExecutor;
    }

}

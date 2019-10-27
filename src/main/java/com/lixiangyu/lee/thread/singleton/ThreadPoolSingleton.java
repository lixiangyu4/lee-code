package com.lixiangyu.lee.thread.singleton;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
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

    /**
     * 优雅关闭线程池
     * @param args
     */
    public static void main(String[] args) {
        //获取java 线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //不需要获取同步的monitor 和synchronizer 信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo info : threadInfos) {
            System.out.println( "[ " + info.getThreadId() + " ] " + info.getThreadName());
        }


    }


}

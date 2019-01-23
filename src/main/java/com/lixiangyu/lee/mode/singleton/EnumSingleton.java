package com.lixiangyu.lee.mode.singleton;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;


/**
 * 单例设计模式
 */
public enum EnumSingleton {
    /**
     *
     */
    INSTANCE(new ThreadPoolExecutor(2, 2, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("aa");
            return thread;
        }
    }, new CallerRunsPolicy()));

    private ThreadPoolExecutor executor;

    EnumSingleton(ThreadPoolExecutor executor) {
        this.executor = executor;
    }

}

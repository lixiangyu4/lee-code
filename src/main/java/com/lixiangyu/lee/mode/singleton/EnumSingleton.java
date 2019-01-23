package com.lixiangyu.lee.mode;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

public enum State {
    /**
     *
     */
    INSTANCE(new ThreadPoolExecutor(2, 2, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            return thread;
        }
    }, new CallerRunsPolicy()));

    private ThreadPoolExecutor executor;

    State(ThreadPoolExecutor executor) {
        this.executor = executor;
    }
}

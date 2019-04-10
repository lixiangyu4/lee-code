package com.lixiangyu.lee.utils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-04-10 14:25
 **/
public class CountDownLatchUtil {

    private CountDownLatch start;
    private CountDownLatch end;
    private int pollSize  =  10;

    public CountDownLatchUtil() {
        this(10);
    }


    public CountDownLatchUtil(int poolSize) {
        this.pollSize = poolSize;
        start = new CountDownLatch(1);
        end = new CountDownLatch(poolSize);
    }

    public void latch(MyFunctionInterface myFunctionInterface) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(pollSize);
        for (int i = 0; i < pollSize; i++) {
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        start.await();
                        myFunctionInterface.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        end.countDown();
                    }
                }
            };
            executorService.submit(run);
        }

        start.countDown();
        end.await();
        executorService.shutdown();

    }

    @FunctionalInterface
    public interface MyFunctionInterface {
        void run();
    }


}

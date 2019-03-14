package com.lixiangyu.lee.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-03-07 15:27
 **/
public class FutureDemo implements Callable<Integer> {

    private AtomicInteger num;

    public FutureDemo(AtomicInteger num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        return num.incrementAndGet();
    }

}

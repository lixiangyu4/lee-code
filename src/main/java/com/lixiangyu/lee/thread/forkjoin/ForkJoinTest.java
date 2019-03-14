package com.lixiangyu.lee.thread.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-03-08 10:19
 **/
public class ForkJoinTest {

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(0, 200000L);
        // 将一个大的任务提交到池中
        ForkJoinTask<Long> result = forkJoinPool.submit(task);
        long res = 0;
        try {
            // 等待运算结果
            res = result.get();
            System.out.println("sum = " + res);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}

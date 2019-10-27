package com.lixiangyu.lee.java8.redo.parallel;

import java.util.concurrent.RecursiveTask;

/**
 * @program: leecode
 * @description: 用分支/合并框架执行并行求和
 * @author: lixiangyu
 * @create: 2019-05-30 17:28
 **/
public class ForkJoinSumCalculator extends RecursiveTask<Long> {


    private final long[] numbers;
    private final int start;
    private final int end;

    private static final long THRESHOLD = 10000;

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if(length <= THRESHOLD) {
            return computeSequentially();
        } else {
            //创建一个子任务来为数组的前一半求和
            ForkJoinSumCalculator leftFork = new ForkJoinSumCalculator(numbers, start, start + length / 2);
            //利用另一个ForkJoinPool线程异步执行新创建的子任务
            leftFork.fork();
            //创建一个子任务执行数字的后一半求和
            ForkJoinSumCalculator rightFork = new ForkJoinSumCalculator(numbers, start + length / 2, end);
            //同步执行第二个子任务，有可能允许进一步递归划分
//            Long rightResult = rightFork.compute();
            rightFork.fork();
            //读取第一个子任务的结果，如果未完成就等待
            Long leftResult = leftFork.join();
            Long rightResult = rightFork.join();
            return rightResult + leftResult;


        }
    }


    /**
     * 顺序计算
     * @return
     */
    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}

package com.lixiangyu.lee.thread.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-03-08 10:38
 **/
public class CountTask extends RecursiveTask<Long> {


    private static final int THRESHOLD = 10000;
    private long start;
    private long end;

    public CountTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {

        long sum = 0;
        //当阀值小于10000则不进行分解
        boolean canCompute = (end - start) < THRESHOLD;
        if(canCompute) {
            for (long i = start; i<=end ; i++) {
                sum += i;
            }
            //大于阀值把任务分解成100份
        } else {
            long step = (end - start ) / 100;
            List<CountTask> subTasks = new ArrayList<>();
            long pos = start;
            for (int i = 0; i<100; i++) {
                long lastone = pos + step;
                if(lastone > end) {
                    lastone = end;
                }
                CountTask subTask = new CountTask(pos, lastone);
                pos += step + 1;
                subTasks.add(subTask);
                subTask.fork();
            }
            for (CountTask task : subTasks) {
                sum += task.join();
            }
        }

        return sum;
    }





}

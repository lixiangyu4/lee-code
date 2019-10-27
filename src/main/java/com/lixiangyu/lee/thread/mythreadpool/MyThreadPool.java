package com.lixiangyu.lee.thread.mythreadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: leecode
 * @description: 自定义线程池
 * @author: lixiangyu
 * @create: 2019-07-02 19:31
 **/
public class MyThreadPool {

    /** 存放线程的集合 */
    private List<MyThread> threads;
    /** 任务队列 */
    private BlockingQueue<Runnable> taskQueue;
    /** 线程池初始大小 */
    private int threadNum;
    /** 已经工作的线程数 */
    private int workThreadNum;

    private final ReentrantLock mainLock = new ReentrantLock();

    public MyThreadPool(int threadNum) {
        this.threadNum = threadNum;
        threads = new ArrayList<>(threadNum);
        //初始化队列为线程数的4倍
        taskQueue = new LinkedBlockingQueue<>(threadNum * 4);
        workThreadNum = 0;
    }

    public void execute(Runnable runnable) {
        try {

            mainLock.lock();
            if (workThreadNum < threadNum) {
                //线程池未满，每加入一个任务则开启一个新的线程
                MyThread myThread = new MyThread(runnable);
                myThread.start();
                threads.add(myThread);
                workThreadNum++;
            } else {
                //如果队列已满，则执行拒绝策略
                if(!taskQueue.offer(runnable)) {
                    rejectTask();
                }
            }


        } finally {
            mainLock.unlock();
        }
    }

    private void rejectTask() {
        System.out.println("任务队列已满，无法继续添加，请扩大您的初始化线程池！");
    }

    class MyThread extends Thread {

        private Runnable task;

        public MyThread(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
            //该线程一直启动，不断从任务队列中取任务来执行
            while (true) {
                if(task != null) {
                    task.run();
                } else {
                    Runnable curTask = taskQueue.poll();
                    if (curTask != null) {
                        curTask.run();
                    } else {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

}

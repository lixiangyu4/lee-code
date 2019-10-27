package com.lixiangyu.lee.thread.mythreadpool;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-07-03 13:59
 **/
public class MyPooTest {

    public static void main(String[] args) {
        MyThreadPool threadPool = new MyThreadPool(5);
        Runnable task = () -> {
            System.out.println("执行任务");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 200 ; i++) {
            threadPool.execute(task);
        }

    }


}

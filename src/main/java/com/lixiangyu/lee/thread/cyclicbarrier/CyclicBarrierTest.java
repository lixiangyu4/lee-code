package com.lixiangyu.lee.thread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @program: leecode
 * @description: CyclicBarrier测试类
 * @author: lixiangyu
 * @create: 2019-01-08 16:22
 **/
public class CyclicBarrierTest {


    static class TestThread implements Runnable {

        private CyclicBarrier cyclicBarrier;


        public TestThread(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据");
            try {
                //以睡眠来模拟写入数据
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + "等待其他线程写入操作..");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");

        }


    }

    public static void main(String[] args) {
        int n = 4;

        CyclicBarrier cyclicBarrier = new CyclicBarrier(n);

        for (int i = 0; i < n ; i++) {
            new Thread(new TestThread(cyclicBarrier)).start();
        }
    }

}

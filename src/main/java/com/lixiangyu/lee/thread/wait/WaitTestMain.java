package com.lixiangyu.lee.thread.wait;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-03-07 16:55
 **/
public class WaitTestMain {


    private static Object lock = new Object();

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("A等待获取锁");
                synchronized (lock) {
                    System.out.println("A获取到了锁");
                    try {
                        System.out.println("开始等待并放弃锁");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("A被唤醒");
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B等待获取锁");
                synchronized (lock) {
                    System.out.println("B获取到了锁");
                    System.out.println("开始唤醒A");
                    lock.notify();
                    System.out.println("线程 B 随机通知 Lock 对象的某个线程");
                }
            }
        }).start();

    }

}

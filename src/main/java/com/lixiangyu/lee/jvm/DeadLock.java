package com.lixiangyu.lee.jvm;

/**
 * @author lixiangyu
 * @description
 * @create 2019-11-03 23:04:13
 */
public class DeadLock {



    public static void main(String[] args) {

        final Object o1 = new Object();
        final Object o2 = new Object();

        new Thread(() -> {
            synchronized (o1) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
                System.out.println("get o1 lock");
                synchronized (o2) {
                    System.out.println("get o2 lock");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (o2) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
                System.out.println("get o2 lock");
                synchronized (o1) {
                    System.out.println("get o1 lock");
                }
            }
        }).start();

    }

}

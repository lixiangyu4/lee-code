package com.lixiangyu.lee.thread.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-05-14 14:32
 **/
public class ReentrantLockTest {


    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();


       new Thread(() -> {
            lock.lock();
            try {
                System.out.println("begin wait");
                condition.await();
                System.out.println("end wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("wait unlock");
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("begin signal");
                condition.signal();
                System.out.println("end signal");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("signal unlock");
                lock.unlock();
            }
        }).start();



    }

}

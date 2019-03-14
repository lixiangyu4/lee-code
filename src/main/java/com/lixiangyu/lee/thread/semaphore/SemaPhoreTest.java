package com.lixiangyu.lee.thread.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-03-07 19:37
 **/
public class SemaPhoreTest {


    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 20 ; i++) {
            semaphore.acquire();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    semaphore.release();
                    System.out.println("释放");
                }
            }).start();
        }
    }

}

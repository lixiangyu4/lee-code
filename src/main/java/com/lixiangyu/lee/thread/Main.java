package com.lixiangyu.lee.thread;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-01-22 13:56
 **/
public class Main {

    public static void main(String[] args) {

//        ThreadPoolSingleton.getInstance().execute(new DemoThread());


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        System.out.println(Thread.currentThread().getState());


    }

}

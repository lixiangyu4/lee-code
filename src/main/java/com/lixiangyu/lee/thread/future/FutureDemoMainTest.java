package com.lixiangyu.lee.thread.future;

import com.lixiangyu.lee.thread.singleton.ThreadPoolSingleton;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-03-07 15:47
 **/
public class FutureDemoMainTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AtomicInteger num = new AtomicInteger(0);
        ThreadPoolExecutor instance = ThreadPoolSingleton.getInstance();
        FutureDemo demoThread = new FutureDemo(num);
        Future<Integer> submit = null;
//        for (int i = 0 ; i < 100; i++) {
//            submit = instance.submit(demoThread);
//        }

        submit = instance.submit(demoThread);

//        instance.shutdown();
        System.out.println(submit.isDone());
        System.out.println(submit.get());
    }

}

package com.lixiangyu.lee.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-07-11 14:27
 **/
public class FutureTaskTest {




    public static void main(String[] args) {

        Callable r = () -> "aa";
        Thread t = new Thread();
        t.start();

        FutureTask futureTask = new FutureTask(r);

    }

}

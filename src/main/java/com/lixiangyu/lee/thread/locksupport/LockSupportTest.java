package com.lixiangyu.lee.thread.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-07-22 12:31
 **/
public class LockSupportTest {

    static ThreadLocal<String> s = new ThreadLocal<>();

    public static void main(String[] args) {
        s.set("");
        LockSupport.park();
        LockSupport.unpark(Thread.currentThread());
    }

}

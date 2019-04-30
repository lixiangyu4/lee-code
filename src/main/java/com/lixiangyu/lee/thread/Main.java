package com.lixiangyu.lee.thread;

import com.lixiangyu.lee.thread.singleton.ThreadPoolSingleton;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-01-22 13:56
 **/
public class Main {

    public static void main(String[] args) {

        ThreadPoolSingleton.getInstance().execute(new DemoThread());



    }

}

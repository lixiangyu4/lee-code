package com.lixiangyu.lee.classloader;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2018-11-20 13:02
 **/
public class SuperClass {

    public static int value = 1;
    public static final String HELLOWORLD = "hello world";

    static {
        System.out.println("SuperClass");
    }

}

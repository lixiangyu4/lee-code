package com.lixiangyu.lee.thread.finall;

/**
 * @program: leecode
 * @description: final例子
 * @author: lixiangyu
 * @create: 2019-07-04 09:47
 **/
public class FinalExample {
    /** 普通变量 */
    int i;
    /** final 变量 */
    final int j;

    static FinalExample obj;

    public FinalExample() {
        i = 1;
        j = 2;
    }

    /** 写线程A执行 */
    public static void writer() {
        obj = new FinalExample();
    }

    /** 读线程B执行 */
    public static void reader() {
        FinalExample object = obj;
        int a = object.i;
        int b = object.j;
    }





}

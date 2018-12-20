package com.lixiangyu.lee.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leecode
 * @description: 堆内存溢出
 * @author: lixiangyu
 * @create: 2018-11-18 17:10
 **/
public class HeapMemory {

    private static List<String> list = new ArrayList<>();

    /**
     * -Xms35M -Xmx35M
     * @param args
     */
    public static void main(String[] args) {
//        while (true) {
//            list.add(new String("aaa"));
//        }
        C c1 = new C();
        C c2 = new C();
        c1.a = c2;
        c1.a = c2;

        c1 = null;
        c2 = null;

        System.gc();

    }



}

class C {
    Object a;
}

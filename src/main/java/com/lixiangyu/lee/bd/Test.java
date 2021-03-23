package com.lixiangyu.lee.bd;

import java.util.Arrays;
import java.util.List;

/**
 * @author lixiangyu
 * @description
 * @create 2020-12-16 23:05:13
 */
public class Test {

    public static void main(String[] args) {
        test02();
    }


    public static void test02() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Object[] array = list.toArray(); // JDK8 返回 Integer[] 数组，JDK9+ 返回 Object[] 数组。
        System.out.println("array className ：" + array.getClass().getSimpleName());

        // 此处，在 JDK8 和 JDK9+ 表现不同，前者会报 ArrayStoreException 异常，后者不会。
        array[0] = new Object();
    }
}

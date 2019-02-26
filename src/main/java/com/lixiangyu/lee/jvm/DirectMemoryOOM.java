package com.lixiangyu.lee.jvm;


import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @program: leecode
 * @description:  VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M
 * @author: lixiangyu
 * @create: 2019-02-12 15:40
 **/
public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field declaredFields = Unsafe.class.getDeclaredFields()[0];
        declaredFields.setAccessible(true);
        Unsafe unsafe = (Unsafe)declaredFields.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }

    }

}

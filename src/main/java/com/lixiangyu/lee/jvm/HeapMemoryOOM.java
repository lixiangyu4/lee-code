package com.lixiangyu.lee.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author lixiangyu
 * @description VM Args: -Xmx32M -Xms32M
 * @create 2019-10-27 15:21:32
 */
public class HeapMemoryOOM {

    private static  List<Person> list = new ArrayList<>();

    public static void main(String[] args) {
        int i = 0;
        while (true) {
            list.add(new Person(i++, UUID.randomUUID().toString()));
        }
    }

}

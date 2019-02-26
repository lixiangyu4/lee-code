package com.lixiangyu.lee.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-01-30 17:33
 **/
public class Test {

    public static void main(String[] args) {

        Map<Person, String> map = new ConcurrentHashMap<>(16);
        map.put(new Person("111", "aaa"), "aaa");
        map.put(new Person("222", "bbb"), "bbb");
        map.put(new Person("333", "ccc"), "ccc");
        map.put(new Person("444", "ddd"), "ddd");

        System.out.println(map);


    }

}

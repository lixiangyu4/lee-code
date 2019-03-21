package com.lixiangyu.lee.java8.map;

import com.lixiangyu.lee.map.Person;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-03-11 14:02
 **/
public class Java8ConcurrentTest {

    public static void main(String[] args) {
        Map<Person, String> map = new ConcurrentHashMap<>(8);
        map.put(new Person("1", "a"), "a");
        map.put(new Person("2", "a"), "a");
        map.put(new Person("3", "a"), "a");
        map.put(new Person("4", "a"), "a");
        map.put(new Person("5", "a"), "a");
        map.put(new Person("6", "a"), "a");
        map.put(new Person("7", "a"), "a");
        map.put(new Person("8", "a"), "a");
        map.put(new Person("9", "a"), "a");
        System.out.println(map);
        System.out.println(map.size());

        String str = new String("");
        AtomicStampedReference<String> atomicStampedReference = new AtomicStampedReference(str, 1);

        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
        Thread thread = new Thread();


    }

}

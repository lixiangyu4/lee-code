package com.lixiangyu.lee.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-01-30 17:33
 **/
public class Test {

    public static void main(String[] args) {

//        Map<Person, String> map = new ConcurrentHashMap<>(8);
//        map.put(new Person("111", "aaa"), "aaa");
//        map.put(new Person("222", "bbb"), "bbb");
//        map.put(new Person("333", "ccc"), "ccc");
//        map.put(new Person("444", "ddd"), "ddd");
//        map.put(new Person("555", "ddd"), "ddd");
//        map.put(new Person("666", "ddd"), "ddd");
//        map.put(new Person("777", "ddd"), "ddd");
//        map.put(new Person("888", "ddd"), "ddd");
//        map.put(new Person("999", "ddd"), "ddd");
//
//        System.out.println(map.size());
//
//        map.get(new Person("444", "ddd"));
//
        Map<Person, String> hashMap = new HashMap<>(8);
        hashMap.put(new Person("111", "aaa"), "aaa");
        hashMap.put(new Person("222", "bbb"), "bbb");
        hashMap.put(new Person("333", "ccc"), "ccc");
        hashMap.put(new Person("444", "ddd"), "ddd");
        hashMap.put(new Person("555", "ddd"), "ddd");
        hashMap.put(new Person("666", "ddd"), "ddd");
        hashMap.put(new Person("777", "ddd"), "ddd");
        hashMap.put(new Person("888", "ddd"), "ddd");
        hashMap.put(new Person("999", "ddd"), "ddd");



        Map<Person, String> linkerhashMap = new LinkedHashMap<>();
        linkerhashMap.put(new Person("111", "aaa"), "aaa");
        linkerhashMap.put(new Person("222", "bbb"), "bbb");
        linkerhashMap.put(new Person("333", "ccc"), "ccc");
        linkerhashMap.put(new Person("444", "ddd"), "ddd");
        linkerhashMap.put(new Person("555", "ddd"), "eee");
        linkerhashMap.put(new Person("666", "ddd"), "fff");
        linkerhashMap.put(new Person("777", "ddd"), "ggg");
        linkerhashMap.put(new Person("888", "ddd"), "hhh");
        linkerhashMap.put(new Person("999", "ddd"), "iii");




//        for (Map.Entry entry : linkerhashMap.entrySet()) {
//            System.out.println(entry.getValue());
//        }

//        System.out.println(1980349397 % 8);
//        System.out.println(1980349397 & 7);
//
//
//        System.out.println(0b000000010000 & 0b010101010001);
//        System.out.println(0x7fffffff);
//
//        System.out.println(new Person("111", "aaa").hashCode() & 8);


    }

}

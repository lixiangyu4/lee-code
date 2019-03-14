package com.lixiangyu.lee.java8.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2018-11-28 15:03
 **/
public class Java8Test {

    public static void main(String[] args) {
        Map<String , String> map  = new HashMap<>(4);
        map.put("1", "a");
//        map.put("2", "b");
////        map.put("3", "c");
////        map.put("4", "d");
////        map.put("5", "e");
        System.out.println(map.toString());
    }

}

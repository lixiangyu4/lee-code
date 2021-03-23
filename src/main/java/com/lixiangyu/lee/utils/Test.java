package com.lixiangyu.lee.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-05-09 09:49
 **/
public class Test {

    public static void main(String[] args) {
//        byte a = 127, b = 5;
//        a(a + b);

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("c");

        List<String> a = list.stream().filter((entity) -> {
            if (entity.equals("a")) {
                return false;
            }
            return true;
        }).collect(Collectors.toList());

        System.out.println(a.toString());

        Map<String, Boolean> tags = new HashMap<>();

        System.out.println(tags.get("a"));
    }



    public static void a(Number a) {
        System.out.println("N");
    }

    public static void a(Byte a) {
        System.out.println(a);
        System.out.println("Y");
    }


}

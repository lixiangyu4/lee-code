package com.lixiangyu.lee.java8.reference;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leecode
 * @description: test2
 * @author: lixiangyu
 * @create: 2018-11-05 10:43
 **/
public class Java8Test2 {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");
        names.forEach(System.out::println);
    }

}

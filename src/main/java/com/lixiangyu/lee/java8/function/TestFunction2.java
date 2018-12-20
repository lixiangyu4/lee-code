package com.lixiangyu.lee.java8.function;

import java.util.function.Function;

/**
 * @program: leecode
 * @description: 2
 * @author: lixiangyu
 * @create: 2018-11-01 16:23
 **/
public class TestFunction2 {

    public static void main(String[] args) {
        Function<Integer, Integer> incr1 = y -> y + 1;
        Function<Integer, Integer> multiply = x -> x * 2;
        System.out.println(incr1.apply(2));
    }

}

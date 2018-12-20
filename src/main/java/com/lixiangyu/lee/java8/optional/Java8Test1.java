package com.lixiangyu.lee.java8.optional;

import java.util.Optional;

/**
 * @program: leecode
 * @description: test
 * @author: lixiangyu
 * @create: 2018-11-07 21:47
 **/
public class Java8Test1 {

    public static void main(String[] args) {
        Java8Test1 java8Test1 = new Java8Test1();
        Integer a = null;
        Integer b = 10;
        Optional<Integer> a1 = Optional.ofNullable(a);
        Optional<Integer> b1 = Optional.of(b);
        System.out.println(java8Test1.sum(a1, b1));
    }


    public int sum(Optional<Integer> a, Optional<Integer> b) {
        System.out.println("判断值是否存在a:"+a.isPresent());
        System.out.println("判断值是否存在a:"+b.isPresent());

        Integer value  = a.orElse(0);

        return value + b.get();
    }

}

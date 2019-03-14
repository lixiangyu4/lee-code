package com.lixiangyu.lee.java8.map;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-03-11 09:56
 **/
public class CalcCapacity {

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(calc(i));
        }

    }

    private static int calc(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : n + 1;
    }

}

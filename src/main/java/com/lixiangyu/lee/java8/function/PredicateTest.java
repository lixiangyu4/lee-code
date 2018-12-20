package com.lixiangyu.lee.java8.function;

import java.util.function.Predicate;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2018-11-08 14:54
 **/
public class PredicateTest {

    public static void main(String[] args) {
        PredicateTest predicateTest = new PredicateTest();
        predicateTest.printBigValue(5, var -> var > 6);
    }


    public void printBigValue(int i, Predicate<Integer> predicate) {

        if(predicate.test(i)) {
            System.out.println(i);
        }

    }

    public void printBigValueAnd(int value, Predicate<Integer> predicate) {
        if (predicate.and(v -> v < 8).test(value)) {
            System.out.println("value < 8 : " + value);
        } else {
            System.out.println("value should < 8 at least.");
        }
    }

}

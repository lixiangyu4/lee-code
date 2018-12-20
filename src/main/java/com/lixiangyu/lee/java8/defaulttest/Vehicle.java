package com.lixiangyu.lee.java8.defaulttest;

public interface Vehicle {

    default void print() {
        System.out.println("three car");
    }

}

package com.lixiangyu.lee.java8.test;

/**
 * @program: leecode
 * @description: lambda表达式实现Runnable接口
 * @author: lixiangyu
 * @create: 2018-11-02 16:59
 **/
public class Java8Test4 {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("aaa"));
        thread.start();


        Runnable runnable = () -> System.out.println("aaa");

    }



}

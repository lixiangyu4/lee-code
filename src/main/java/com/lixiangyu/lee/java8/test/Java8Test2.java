package com.lixiangyu.lee.java8.test;

/**
 * @program: leecode
 * @description: test
 * @author: lixiangyu
 * @create: 2018-11-01 17:39
 **/
public class Java8Test2 {

    private static String salutation = "hello";

    public static void main(String[] args) {

        MathOperator add = (a, b) -> a + b;
        MathOperator subtract = (int a, int b) -> a - b;
        MathOperator mul = (int a, int b) -> a * b;
        MathOperator aaa = (a , b) -> {
            System.out.println(a);
            System.out.println(b);
            return a + b;
        };

        Java8Test2 java8Test2 = new Java8Test2();
        //lambda可以使用局部变量
        int num = 1;
        GreetingService greetingService1 = (String message) -> {
            System.out.println(num + message);
        };
        greetingService1.sayMessage("lambda使用局部变量");
        //lambda可以使用static的成员变量
        GreetingService greetingService2 = (String message) -> {
            System.out.println(salutation + message);
        };
        greetingService2.sayMessage("lambda使用成员变量");
    }



    interface MathOperator {
        int operator(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }



}

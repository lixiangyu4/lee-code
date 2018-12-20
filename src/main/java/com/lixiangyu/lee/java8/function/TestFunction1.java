package com.lixiangyu.lee.java8.function;

/**
 * @program: leecode
 * @description: java8测试方法
 * @author: lixiangyu
 * @create: 2018-11-01 16:09
 **/
public class TestFunction1 {

    public static void main(String[] args) {
        TestFunction1 testFunction1 = new TestFunction1();
        testFunction1.test(10, () -> System.out.println("aaaa"));
        testFunction1.test(100, testFunction1::customFunc);
    }

    public void customFunc() {
        System.out.println("A customed method reference.");
    }

    public void test(int x , Func func) {
        System.out.println(x);
        func.foo();
    }

}

package com.lixiangyu.lee.mode.strategy;

/**
 * @program: leecode
 * @description: 策略模式测试类
 * @author: lixiangyu
 * @create: 2019-05-16 20:00
 **/
public class MainTest {

    private static void cashContext(ICashSuper cash) {
        System.out.println(cash.acceptCash());
    }

    public static void main(String[] args) {
        cashContext(new CashNormal());
    }

}

package com.lixiangyu.lee.mode.template;

/**
 * @program: leecode
 * @description: 超市account
 * @author: lixiangyu
 * @create: 2019-02-28 15:01
 **/
public class MarketAccount extends AbstractAccount {
    @Override
    protected void abstractMethod() {
        System.out.println("MarketAccount's abstractMethod");
    }
    @Override
    protected void hookMethod(){
        System.out.println("MarketAccount's method");
    }
}

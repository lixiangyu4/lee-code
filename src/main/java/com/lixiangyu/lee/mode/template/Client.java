package com.lixiangyu.lee.mode.template;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-02-28 15:03
 **/
public class Client {

    public static void main(String[] args) {
        AbstractAccount account = new MarketAccount();
        account.templateMethod();
    }

}

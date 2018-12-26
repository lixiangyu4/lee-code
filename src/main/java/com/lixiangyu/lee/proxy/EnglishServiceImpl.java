package com.lixiangyu.lee.proxy;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2018-12-25 22:26
 **/
public class EnglishServiceImpl implements IPersonService {
    @Override
    public void sayHello() {
        System.out.println("HI ~");
    }

    @Override
    public void printName(String name) {
        System.out.println("YOUR NAME :" + name);
    }
}

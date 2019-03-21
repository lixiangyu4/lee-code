package com.lixiangyu.lee.proxy.cglib;

import org.assertj.core.internal.cglib.proxy.Enhancer;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-03-21 11:16
 **/
public class InterceptorTest {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MyTarget.class);
        enhancer.setCallback( new MyInterceptor());
        MyTarget target = (MyTarget) enhancer.create();
        target.printName();
        System.out.println("proxy class name:" + target.getClass().getName());
    }

}

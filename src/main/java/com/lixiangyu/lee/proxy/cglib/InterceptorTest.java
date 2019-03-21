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
        MyTarget myTarget = new MyTarget();
        MyInterceptor interceptor = new MyInterceptor();

        //cglib 中加强器，用来创建动态代理
        Enhancer enhancer = new Enhancer();
        //设置要创建动态代理的类
        enhancer.setSuperclass(myTarget.getClass());
        // 设置回调，这里相当于是对于代理类上所有方法的调用，
        // 都会调用CallBack，而Callback则需要实行intercept()方法进行拦截
        enhancer.setCallback(interceptor);
        MyTarget target = (MyTarget) enhancer.create();
        target.printName();
        System.out.println("proxy class name:" + target.getClass().getName());
    }

}

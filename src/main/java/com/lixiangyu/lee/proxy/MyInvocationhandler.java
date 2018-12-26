package com.lixiangyu.lee.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2018-12-25 22:28
 **/
public class MyInvocationhandler implements InvocationHandler {

    private Object target;

    public MyInvocationhandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("begin---");
        method.invoke(target, args);
        System.out.println("end ----");
        return null;
    }
}

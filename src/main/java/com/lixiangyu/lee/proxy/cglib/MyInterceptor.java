package com.lixiangyu.lee.proxy.cglib;


import org.assertj.core.internal.cglib.proxy.MethodInterceptor;
import org.assertj.core.internal.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-03-21 11:13
 **/
public class MyInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        System.out.println("=======before======");
        Object o = proxy.invokeSuper(obj, args);

        System.out.println("=======end======");

        return o;
    }
}

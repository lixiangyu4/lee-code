package com.lixiangyu.lee.proxy.javassist;

import java.lang.reflect.InvocationHandler;

public interface ProxyFactory {

    <T> T getProxy(Object target, InvocationHandler handler) throws Throwable;

}

//package com.lixiangyu.lee.proxy.javassist;
//
//import sun.misc.ProxyGenerator;
//
//import java.lang.reflect.InvocationHandler;
//
///**
// * @program: leecode
// * @description:
// * @author: lixiangyu
// * @create: 2019-03-21 11:31
// **/
//public class JavassistProxyFactory implements ProxyFactory {
//    @Override
//    public <T> T getProxy(Object target, InvocationHandler handler) throws Throwable {
//        return (T) ProxyGenerator.newProxyInstance(Thread.currentThread().getContextClassLoader(),
//            target.getClass(), handler);
//    }
//}

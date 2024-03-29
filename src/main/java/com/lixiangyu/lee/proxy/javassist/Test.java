package com.lixiangyu.lee.proxy.javassist;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-03-21 16:28
 **/
public class Test {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        System.out.println("*******************方式一*******************");
        JavassistProxyFactory<A> jpf = new JavassistProxyFactory<A>();
        A a = new A();
        jpf.setTarget(a);
        A proxy = jpf.getProxy();
        proxy.del();

        System.out.println("*******************方式二*******************");
        JavassistProxyFactory02 jpf02 = new JavassistProxyFactory02();
        A a2 = (A) jpf02.getProxy(A.class);
        a2.del();
        a2.save();
    }

}

package com.lixiangyu.lee.proxy.normal;

import com.lixiangyu.lee.utils.ProxyUtils;

import java.lang.reflect.Proxy;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2018-12-25 22:30
 **/
public class Test {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        EnglishServiceImpl englishService = new EnglishServiceImpl();
        //1、获取对应的classLoader
        ClassLoader classLoader = englishService.getClass().getClassLoader();
        //2、获取代理类实现的所有接口
        Class<?>[] interfaces = englishService.getClass().getInterfaces();
        //3、设置一个来自代理传过来的方法调用请求处理器，处理所有的代理对象上的方法调用
        MyInvocationhandler myInvocationhandler = new MyInvocationhandler(englishService);
        /*
		  4.根据上面提供的信息，创建代理对象 在这个过程中，
            a.JDK会通过根据传入的参数信息动态地在内存中创建和.class 文件等同的字节码
            b.然后根据相应的字节码转换成对应的class，
            c.然后调用newInstance()创建实例
		*/
        IPersonService personService =  (IPersonService) Proxy.newProxyInstance(classLoader,
            interfaces, myInvocationhandler);
        personService.sayHello();

        ProxyUtils.generateClassFile(personService.getClass(), personService.getClass().getName());

    }



}

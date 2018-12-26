package com.lixiangyu.lee.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.Proxy;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2018-12-25 22:30
 **/
public class Test {

    public static void main(String[] args) {
        MyInvocationhandler myInvocationhandler = new MyInvocationhandler(new EnglishServiceImpl());
        IPersonService personService =  (IPersonService) Proxy.newProxyInstance(Test.class.getClassLoader(),
                new Class[]{IPersonService.class}, myInvocationhandler);
        personService.sayHello();

        String fileName = "$Proxy11";
        byte[] bytes = ProxyGenerator.generateProxyClass(fileName, EnglishServiceImpl.class.getInterfaces());
        FileOutputStream out = null;
        String outFilePath = "/Users/lixiangyu/phoenix/lee-code/" + fileName + ".class";
        try {
            out = new FileOutputStream(outFilePath);
            out.write(bytes);
            out.flush();
        }catch (Exception e) {

        } finally {
            try {
                out.close();
            }catch (Exception e) {

            }
        }
    }



}

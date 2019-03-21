package com.lixiangyu.lee.classloader;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: leecode
 * @description: 类加载器测试
 * @author: lixiangyu
 * @create: 2019-03-20 22:29
 **/
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader loader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1)+".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if(is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b , 0, b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw  new ClassNotFoundException();
                }

            }
        };

        Object obj = loader.loadClass("com.lixiangyu.lee.classloader.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof ClassLoaderTest);

    }

}

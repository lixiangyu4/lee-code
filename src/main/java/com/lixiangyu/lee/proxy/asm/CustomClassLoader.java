package com.lixiangyu.lee.proxy.asm;

/**
 * @program: leecode
 * @description: 自定义类加载器
 * @author: lixiangyu
 * @create: 2019-03-21 14:21
 **/
public class CustomClassLoader extends ClassLoader {

    public Class<?> defineMyClass( byte[] b, int off, int len) {
        return super.defineClass(b, off, len);
    }


}

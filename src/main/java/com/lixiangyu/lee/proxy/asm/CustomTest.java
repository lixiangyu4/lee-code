package com.lixiangyu.lee.proxy.asm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-03-21 14:23
 **/
public class CustomTest {


    /**
     * 1、自定义类加载器
     * 2、加载编译后的class文件
     * 3、通过反射调用需要执行的方法
     * @param args
     * @throws IOException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //将字节码文件转换为本地字节数组
        File file = new File("/Users/lixiangyu/phoenix/lee-code/target/classes/com/lixiangyu/lee/proxy/asm/Programmer.class");
        InputStream is = new FileInputStream(file);
        byte[] result = new byte[1024];

        int count = is.read(result);
        // 使用自定义的类加载器将 byte字节码数组转换为对应的class对象
        CustomClassLoader loader = new CustomClassLoader();
        Class clazz = loader.defineMyClass( result, 0, count);
        //测试加载是否成功，打印class 对象的名称
        System.out.println(clazz.getCanonicalName());
        //反射实例化一个对象
        Object o = clazz.newInstance();
        //调用code方法
        clazz.getMethod("code").invoke(o, null);

    }

}

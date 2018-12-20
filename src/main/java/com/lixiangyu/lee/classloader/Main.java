package com.lixiangyu.lee.classloader;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2018-11-20 13:03
 **/
public class Main {

    public static void main(String[] args) {
        /**
         * 被动使用类字段演示1：通过子类引用父类的静态字段，不会导致子类初始化
         */
//        System.out.println(SubClass.value);
        /**
         * 被动使用类字段演示2：通过数组定义来引用类，不会触发此类的初始化
         */
//        SuperClass[] arr = new SuperClass[10];
        /**
         * 被动使用类字段演示3：常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会出发定义常量类的初始化
         */
        System.out.println(SuperClass.HELLOWORLD);

    }

}

package com.lixiangyu.lee.java8.test;

/**
 * @program: leecode
 * @description: test
 * @author: lixiangyu
 * @create: 2018-11-02 16:22
 **/
public class Java8Test3 {

    public static void main(String[] args) {
        int o1 = 2;
        Converter<String,Integer> converter = (o2) -> System.out.println(o2 + o1);
        converter.convert(1);
    }


    interface Converter<T1,T2> {
        void convert(int i);
    }

}

package com.lixiangyu.lee.spi;

import java.util.Optional;
import java.util.ServiceLoader;
import java.util.stream.StreamSupport;

/**
 * @program: leecode
 * @description: 测试类
 * @author: lixiangyu
 * @create: 2018-11-01 14:08
 **/
public class Main {

    public static void main(String[] args) {


        ServiceLoader<ObjectSerializer> load = ServiceLoader.load(ObjectSerializer.class);

        Optional<ObjectSerializer> first = StreamSupport.stream(load.spliterator(), false).findFirst();
        final ObjectSerializer objectSerializera = first.get();
        System.out.println(objectSerializera.getSchemeName());





    }

}

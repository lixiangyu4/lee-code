package com.lixiangyu.lee.java8.redo.stream;

import lombok.Data;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-05-24 16:33
 **/
@Data
public class Trader {


    private final String name;
    private final String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Trader{" +
            "name='" + name + '\'' +
            ", city='" + city + '\'' +
            '}';
    }
}

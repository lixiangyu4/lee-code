package com.lixiangyu.lee.java8.redo.frunctioninterface;

import lombok.Data;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-05-16 19:09
 **/
@Data
public class Apple extends Fruit {

    private String name;
    private String weight;
    private String place;
    private Integer number;
    private String color;

    public Apple(Integer number) {
        this.number = number;
    }

    public Apple() {
    }

    @Override
    public String toString() {
        return "Apple{" +
            "name='" + name + '\'' +
            ", weight='" + weight + '\'' +
            ", place='" + place + '\'' +
            ", number=" + number +
            '}';
    }
}

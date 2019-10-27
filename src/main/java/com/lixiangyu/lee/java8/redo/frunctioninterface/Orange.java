package com.lixiangyu.lee.java8.redo.frunctioninterface;

import lombok.Data;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-05-17 20:37
 **/
@Data
public class Orange extends Fruit {

    private String name;
    private String weight;
    private String place;
    private Integer number;

    public Orange(Integer number) {
        this.number = number;
    }

    public Orange() {
    }

    @Override
    public String toString() {
        return "Orange{" +
            "name='" + name + '\'' +
            ", weight='" + weight + '\'' +
            ", place='" + place + '\'' +
            ", number=" + number +
            '}';
    }
}

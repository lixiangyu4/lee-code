package com.lixiangyu.lee.java8.redo.stream;

import lombok.Data;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-05-20 10:07
 **/
@Data
public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Dish{" +
            "name='" + name + '\'' +
            '}';
    }

    public enum Type {
        MEAT,FISH,OTHER
    }

}

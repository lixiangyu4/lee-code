package com.lixiangyu.lee.java8.redo.optional;

import java.util.Optional;

import lombok.Data;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-06-05 17:57
 **/
@Data
public class Person {

    private Car car;


    public Optional<Car> getCarAsOptional() {
        return Optional.ofNullable(car);
    }


}

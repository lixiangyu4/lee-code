package com.lixiangyu.lee.java8.redo.optional;

import org.junit.Test;

import java.util.Optional;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-06-05 17:18
 **/
public class OptionalTest {

    @Test
    public void test_01() {

        Car car = new Car();
        Optional<Car> optional = Optional.of(car);

        Insurance insurance = new Insurance();
        Optional<Insurance> optionalInsurance = Optional.of(insurance);
        optionalInsurance.map(Insurance::getName);

    }

    @Test
    public void test_02() {

        Person person = new Person();
        Optional<Car> carAsOptional = person.getCarAsOptional();
        carAsOptional.orElse(new Car());
        carAsOptional.orElseGet(Car::new);

    }

}

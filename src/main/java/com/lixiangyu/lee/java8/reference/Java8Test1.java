package com.lixiangyu.lee.java8.reference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @program: leecode
 * @description: 方法引用
 * @author: lixiangyu
 * @create: 2018-11-03 13:32
 **/
public class Java8Test1 {

    public static void main(String[] args) {
        Supplierz<Car> carSupplierz = Car::new;

        Car car = carSupplierz.get();

        List<Car> carList = Arrays.asList(car);

        carList.forEach(Car::collide);

        carList.forEach(Car::repair);

        Consumer<Car> collide = Car::collide;
        collide.accept(car);
        Car car1 = Car.create(Car::new);
        carList.forEach(car1::follow);

    }


}

@FunctionalInterface
interface Supplierz<T> {
    T get();
}

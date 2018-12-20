package com.lixiangyu.lee.java8.reference;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2018-11-03 13:33
 **/
public class Car {

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }


    public void repair() {
        System.out.println("Repaired " );
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public static Car create(Supplierz<Car> supplierz) {
        return supplierz.get();
    }

}

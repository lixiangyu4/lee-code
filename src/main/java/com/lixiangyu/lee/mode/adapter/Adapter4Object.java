package com.lixiangyu.lee.mode.adapter;

/**
 * @program: leecode
 * @description: 对象适配器模式
 *  对象适配器模式
 *  * 　　与类的适配器模式一样，对象的适配器模式把被适配的类的API转换成为目标类的API，
 *  *    与类的适配器模式不同的是，对象的适配器模式不是使用继承关系连接到Adaptee类，而是使用委派关系连接到Adaptee类。
 * @author: lixiangyu
 * @create: 2019-06-18 17:10
 **/
public class Adapter4Object implements Target {

    private Adaptee adaptee;

    public Adapter4Object(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void sampleOperation1() {

    }

    @Override
    public void sampleOperation2() {
        adaptee.sampleOperation2();
    }
}

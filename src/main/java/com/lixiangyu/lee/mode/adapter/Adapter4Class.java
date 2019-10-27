package com.lixiangyu.lee.mode.adapter;

/**
 * @program: leecode
 * @description: 适配器模式  : 适配器类是本模式的核心。适配器把源接口转换成目标接口。显然，这一角色不可以是接口，而必须是具体类。
 *
 * 类适配器模式
 * 　　类的适配器模式把适配的类的API转换成为目标类的API。
 * 对象适配器模式
 * 　　与类的适配器模式一样，对象的适配器模式把被适配的类的API转换成为目标类的API，
 *    与类的适配器模式不同的是，对象的适配器模式不是使用继承关系连接到Adaptee类，而是使用委派关系连接到Adaptee类。
 *
 * 适配器角色Adapter扩展了Adaptee,同时又实现了目标(Target)接口。由于Adaptee没有提供sampleOperation2()方法，
 * 而目标接口又要求这个方法，因此适配器角色Adapter实现了这个方法。
 *
 *
 * @author: lixiangyu
 * @create: 2019-06-18 14:33
 **/
public class Adapter4Class extends Adaptee implements Target {

    @Override
    public void sampleOperation1() {

    }

    @Override
    public void sampleOperation2() {

    }


}

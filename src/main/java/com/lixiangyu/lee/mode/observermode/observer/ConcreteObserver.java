package com.lixiangyu.lee.mode.observermode.observer;

/**
 * @program: leecode
 * @description: 观察者模式-具体的观察者
 * @author: lixiangyu
 * @create: 2019-01-22 21:43
 **/
public class ConcreteObserver implements Observer {

    public String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "收到推送消息：" + message);
    }
}

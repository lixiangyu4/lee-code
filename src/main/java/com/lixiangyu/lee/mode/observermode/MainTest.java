package com.lixiangyu.lee.mode.observermode;

import com.lixiangyu.lee.mode.observermode.observer.ConcreteObserver;
import com.lixiangyu.lee.mode.observermode.observer.Observer;
import com.lixiangyu.lee.mode.observermode.subject.ConcreteSubject;
import com.lixiangyu.lee.mode.observermode.subject.Subject;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-01-22 22:39
 **/
public class MainTest {

    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();

        Observer observer1 = new ConcreteObserver("小明");
        Observer observer2 = new ConcreteObserver("小李");
        Observer observer3 = new ConcreteObserver("小张");

        subject.registerObserver(observer1);
        subject.registerObserver(observer2);
        subject.registerObserver(observer3);

        subject.notifyObserver("aaa");

        subject.removeObserver(observer2);

        subject.notifyObserver("bbb");



    }

}

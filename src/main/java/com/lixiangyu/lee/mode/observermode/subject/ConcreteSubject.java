package com.lixiangyu.lee.mode.observermode.subject;

import com.lixiangyu.lee.mode.observermode.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leecode
 * @description: 观察者模式-具体的主题
 * @author: lixiangyu
 * @create: 2019-01-22 21:39
 **/
public class ConcreteSubject implements Subject {

    private List<Observer> observerList;

    public ConcreteSubject() {
        observerList = new ArrayList<>();
    }


    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if(!observerList.isEmpty()) {
            observerList.remove(observer);
        }
    }

    @Override
    public void notifyObserver(String message) {
        if(null != observerList) {
            for (Observer observer : observerList) {
                observer.update(message);
            }
        }

    }
}

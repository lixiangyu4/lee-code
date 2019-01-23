package com.lixiangyu.lee.mode.observermode.subject;

import com.lixiangyu.lee.mode.observermode.observer.Observer;

/**
 * 观察者模式-主题
 */
public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver(String message);


}

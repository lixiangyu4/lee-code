package com.lixiangyu.lee.mode.observermode.observer;

/**
 * 观察者模式-观察者
 */
public interface Observer {

    /**
     * 当subject调用notify时，observer的update方法会被回掉
     */
    void update(String message);

}

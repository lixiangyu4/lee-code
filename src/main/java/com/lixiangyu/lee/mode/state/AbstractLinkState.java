package com.lixiangyu.lee.mode.state;

/**
 * @program: leecode
 * @description: 状态模式
 * @author: lixiangyu
 * @create: 2019-01-22 19:40
 **/
public abstract class AbstractLinkState {

    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    /**
     * 扛炸药包
     */
    abstract void carry();

    /**
     * 放置炸药包
     */
    abstract void put();

    /**
     * 跑路
     */
    abstract void goaway();

    /**
     * 点燃炸药包
     */
    abstract void ignite();



}

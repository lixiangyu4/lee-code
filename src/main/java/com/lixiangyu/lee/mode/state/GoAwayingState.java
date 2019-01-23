package com.lixiangyu.lee.mode.state;

/**
 * @program: leecode
 * @description: 状态模式
 * @author: lixiangyu
 * @create: 2019-01-22 19:56
 **/
public class GoAwayingState extends AbstractLinkState {
    @Override
    void carry() {
        System.out.println("小Y:已经逃离，无法再扛炸药包");
    }

    @Override
    void put() {
        System.out.println("小Y:已经逃离，无法进行炸药包放置");
    }

    @Override
    void goaway() {
        System.out.println("小Y:呼~~，终于捡回条小命");
    }

    @Override
    void ignite() {
        this.context.setLinkState(Context.IGNITING_STATE);
        this.context.igniting();
    }
}

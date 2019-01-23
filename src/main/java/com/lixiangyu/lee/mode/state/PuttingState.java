package com.lixiangyu.lee.mode;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-01-22 19:56
 **/
public class PuttingState extends AbstractLinkState {
    @Override
    void carry() {
        System.out.println("小Y:还在敌方区，无法再扛炸药包");
    }

    @Override
    void put() {
        System.out.println("小Y:好险，成功把放置炸药包");
    }

    @Override
    void goaway() {
        this.context.setLinkState(Context.GO_AWAYING_STATE);
        this.context.goaway();
    }

    @Override
    void ignite() {
        System.out.println("小Y:还没逃离敌方区，无法引爆炸药");
    }
}

package com.lixiangyu.lee.mode;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-01-22 20:01
 **/
public class IgnitingState extends AbstractLinkState {
    @Override
    void carry() {
        System.out.println("炮楼没彻底倒下，小Y继续扛炸药");
        this.context.setLinkState(Context.CARRYING_STATE);
        this.context.carry();
    }

    @Override
    void put() {
        System.out.println("小Y:炸药已引爆，无须进行炸药包放置");
    }

    @Override
    void goaway() {
        System.out.println("小Y:炸药已引爆，早已撤离");
    }

    @Override
    void ignite() {
        System.out.println("小Y:炸楼完成，准备加薪晋职");
    }
}

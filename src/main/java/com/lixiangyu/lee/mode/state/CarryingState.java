package com.lixiangyu.lee.mode.state;

/**
 * @program: leecode
 * @description: 状态模式
 * @author: lixiangyu
 * @create: 2019-01-22 19:55
 **/
public class CarryingState extends AbstractLinkState {
    @Override
    void carry() {
        System.out.println("小Y:报告排长，我已跑到炮楼底下");
    }


    //继承AbstractLinkState的所有状态的操作类都是进行对应状态的操作，
    // 都是操作类，不进行状态的保存，所以需要调用context中的方法才可以
    @Override
    void put() {
        this.context.setLinkState(Context.PUTTING_STATE);
        this.context.put();
    }

    @Override
    void goaway() {
        System.out.println("小Y:还没放置炸药成功，撤离失败");
    }

    @Override
    void ignite() {
        System.out.println("小Y:还没放置炸药成功，引爆失败");
    }
}

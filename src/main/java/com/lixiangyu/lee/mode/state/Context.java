package com.lixiangyu.lee.mode.state;

public class Context {

    public final static CarryingState CARRYING_STATE = new CarryingState();
    public final static PuttingState PUTTING_STATE = new PuttingState();
    public final static GoAwayingState GO_AWAYING_STATE = new GoAwayingState();
    public final static IgnitingState IGNITING_STATE = new IgnitingState();


    //设置当前状态
    private AbstractLinkState linkState;

    public AbstractLinkState getLinkState() {
        return linkState;
    }

    public void setLinkState(AbstractLinkState linkState) {
        this.linkState= linkState;
        //把当前的所处的状态通知到各个实现类中
        this.linkState.setContext(this);
    }

    public void carry() {
        linkState.carry();
    }

    public void put() {
        linkState.put();
    }

    public void goaway() {
        linkState.goaway();
    }

    public void igniting() {
        linkState.ignite();
    }

}

package com.lixiangyu.lee.mode;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-01-22 20:36
 **/
public class Client {

    public static void main(String[] args) {
        Context context = new Context();
        context.setLinkState(Context.CARRYING_STATE);
        context.carry();
        context.put();
        context.goaway();
        context.igniting();
    }

}

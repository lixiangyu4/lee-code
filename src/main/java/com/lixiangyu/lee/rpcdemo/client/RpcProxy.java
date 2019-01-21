package com.lixiangyu.lee.rpcdemo.client;

import java.lang.reflect.Proxy;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-01-20 21:57
 **/
public class RpcProxy {

    public <T> T create(Class<?> clazz) {
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new ClientHandler());
    }

}

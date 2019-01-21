package com.lixiangyu.lee.rpc.demo.server.service.impl;

import com.lixiangyu.lee.rpc.api.IHelloService;
import com.lixiangyu.lee.rpc.api.RpcService;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-01-21 10:38
 **/
@RpcService("HelloServiceImpl")
public class HelloServiceImpl implements IHelloService {
    @Override
    public String say() {
        return "hello world";
    }
}

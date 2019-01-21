package com.lixiangyu.lee.rpc.demo.client;

import com.lixiangyu.lee.rpc.api.IHelloService;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-01-21 10:40
 **/
public class TestHelloService {

    private IHelloService helloService;

    public void hello() {
        helloService.say();
    }

}

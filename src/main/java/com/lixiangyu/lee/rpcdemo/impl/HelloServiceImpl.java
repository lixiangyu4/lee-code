package com.lixiangyu.lee.rpcdemo.impl;

import com.lixiangyu.lee.rpcdemo.IHelloService;
import com.lixiangyu.lee.rpcdemo.RpcService;
import org.springframework.stereotype.Service;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-01-20 16:21
 **/
@RpcService("HelloServiceImpl")
@Service
public class HelloServiceImpl implements IHelloService {
    @Override
    public String say() {
        return "hello world";
    }
}

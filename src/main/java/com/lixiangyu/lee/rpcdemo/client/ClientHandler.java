package com.lixiangyu.lee.rpcdemo.client;

import com.lixiangyu.lee.rpcdemo.dto.RpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-01-20 21:59
 **/
public class ClientHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setRequestId(UUID.randomUUID().toString());
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setParamTypes(method.getParameterTypes());
        rpcRequest.setArgs(args);


        return null;
    }
}

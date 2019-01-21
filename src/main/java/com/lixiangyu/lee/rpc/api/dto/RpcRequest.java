package com.lixiangyu.lee.rpc.api.dto;

import lombok.Data;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-01-20 22:00
 **/
@Data
public class RpcRequest {

    private String requestId;
    private String className;
    private String methodName;
    private Class<?>[] paramTypes;
    private Object[] args;

}

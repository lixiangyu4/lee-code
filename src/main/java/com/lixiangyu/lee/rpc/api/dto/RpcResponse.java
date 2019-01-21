package com.lixiangyu.lee.rpc.api.dto;

import lombok.Data;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-01-21 10:20
 **/
@Data
public class RpcResponse {

    private String requestId;
    private Throwable exception;
    private Object result;

}

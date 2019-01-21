package com.lixiangyu.lee.rpcdemo.dto;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-01-20 22:00
 **/
public class RpcRequest {

    private String requestId;
    private String className;
    private String methodName;
    private Class<?>[] paramTypes;
    private Object[] args;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class<?>[] paramTypes) {
        this.paramTypes = paramTypes;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}

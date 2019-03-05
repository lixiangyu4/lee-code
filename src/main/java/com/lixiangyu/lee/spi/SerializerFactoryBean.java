package com.lixiangyu.lee.spi;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-03-04 17:02
 **/
public class SerializerFactoryBean<T> implements FactoryBean<T> {

    private Class<? extends ObjectSerializer> spiClz;

    private List<ObjectSerializer> list;

    public SerializerFactoryBean(ApplicationContext applicationContext, Class<? extends ObjectSerializer> clz) {
        this.spiClz = clz;

        Map<String, ? extends ObjectSerializer> map = applicationContext.getBeansOfType(spiClz);
        list = new ArrayList<>(map.values());
    }


    @Override
    public T getObject() throws Exception {

        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                for (ObjectSerializer serializer  : list) {
                    return method.invoke(serializer, args);
                }
                return null;
            }
        };
        return (T)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{spiClz},  invocationHandler);
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}

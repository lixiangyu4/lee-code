package com.lixiangyu.lee.springboot.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-03-04 23:23
 **/
public class Car implements InitializingBean, DisposableBean, BeanPostProcessor {

   public void init_method() {
       System.out.println("init_method=====");
   }


    public void destroy_method() {
        System.out.println("destroy_method=====");
    }

    public Car () {
        System.out.println("构造函数");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet====");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy====");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization====");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization====");
        return bean;
    }

    @PostConstruct
    public void init() {
        System.out.println("init");
    }

    @PreDestroy
    public void des() {
        System.out.println("des");
    }
}

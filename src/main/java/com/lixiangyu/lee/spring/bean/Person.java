package com.lixiangyu.lee.spring.bean;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2018-11-24 15:33
 **/
@Data
public class Person implements InitializingBean, BeanPostProcessor, BeanFactoryAware {

    private long id;
    private String name;

    public Person(long id, String name) {
        System.out.println("构造函数");
        this.id = id;
        this.name = name;
    }

    public void init_mothod() {
        System.out.println("init_mothod");
    }

    public void destory_mothod() {
        System.out.println("destory_mothod");
    }

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct");
    }

    @PreDestroy
    public void destory() {
        System.out.println("PreDestroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization: " +  beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization : " + beanName);
        return bean;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }
}

package com.lixiangyu.lee.spring.condition;

import com.lixiangyu.lee.spring.bean.Color;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-02-08 22:12
 **/
public class ColorImportBeanDefinitionSelector implements ImportBeanDefinitionRegistrar {
    /**
     * AnnotationMetadata 当前类的注解信息，
     * BeanDefinitionRegistry BeanDefinition注册类；把所有需要添加到容器中的bean调用
     * BeanDefinitionRegistry.registerBeanDefinition();方法手动注册进来
     * @param importingClassMetadata
     * @param registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Color.class);
        registry.registerBeanDefinition("black", rootBeanDefinition);
    }
}

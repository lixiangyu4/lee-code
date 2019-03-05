package com.lixiangyu.lee.springboot.im;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-03-04 22:52
 **/
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param importingClassMetadata 当前类的注解的全部信息
     * @param registry Bean定义的注册类 手动注册到IOC容器中
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        boolean blue = registry.containsBeanDefinition("com.lixiangyu.lee.springboot.im.Blue");
        boolean red = registry.containsBeanDefinition("com.lixiangyu.lee.springboot.im.Red");
        BeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class );
        if(blue && red) {
            registry.registerBeanDefinition("rainBow", beanDefinition);
        }

    }
}

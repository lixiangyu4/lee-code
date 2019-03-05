package com.lixiangyu.lee.springboot.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-03-04 22:02
 **/
public class LinuxCondition implements Condition {

    /**
     *
     * @param context 判断条件能使用的上下文环境
     * @param metadata 当前标注conditional注解的标注信息 
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        //获取当前环境的信息
        Environment environment = context.getEnvironment();
        //获取当前类加载器的信息
        ClassLoader classLoader = context.getClassLoader();
        //获取当前IOC容器的BeanFactory 
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //获取bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        String property = environment.getProperty("os.name");
        if(property.contains("Linux")) {
            return true;
        }

        return false;
    }
}

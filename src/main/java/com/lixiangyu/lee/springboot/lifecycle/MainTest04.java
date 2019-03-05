package com.lixiangyu.lee.springboot.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-03-04 23:17
 **/
public class MainTest04 {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
            = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
        context.close();
    }

}

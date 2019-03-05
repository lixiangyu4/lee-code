package com.lixiangyu.lee.springboot;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-03-04 20:57
 **/
public class MainTest01 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
            = new AnnotationConfigApplicationContext(MainConfig1.class);

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

}

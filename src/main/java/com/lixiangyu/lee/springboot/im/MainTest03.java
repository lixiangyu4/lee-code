package com.lixiangyu.lee.springboot.im;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-03-04 22:33
 **/
public class MainTest03 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig3.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

}

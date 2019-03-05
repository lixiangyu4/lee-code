package com.lixiangyu.lee.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-03-04 20:57
 **/
@Configuration
@ComponentScan(value = "com.lixiangyu.lee.springboot",excludeFilters = {
    @ComponentScan.Filter(type= FilterType.ANNOTATION, value = {Service.class}),
    @ComponentScan.Filter(type= FilterType.CUSTOM, value = {MyFilter.class})

})
public class MainConfig1 {

    /**
     * @Scope
     * singleton（默认） : 初始化IOC容器的时候就调用方法创建对象到IOC容器中，以后每次获取的时候都是从map中获取
     * prototype : IOC容器启动时并不会创建对象，每获取一次对象创建一次对象
     * @return
     */
    /**
     * @Lazy :懒加载
     * 对于单实例的Bean而言的，使用此注解后，初始化IOC容器时不会创建Bean，第一次使用时才会创建
     * @return
     */
    @Bean("person")
    public Person getPerson() {
        return new Person("a", 1);

    }





}

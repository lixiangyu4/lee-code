package com.lixiangyu.lee.springboot.condition;

import com.lixiangyu.lee.springboot.Person;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-03-04 21:52
 **/
public class MainTest02 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(MainConfig2.class);


        String[] beanNamesForType = context.getBeanNamesForType(Person.class);

        for (String name : beanNamesForType) {
            System.out.println(name);
        }

        Map<String, Person> beansOfType = context.getBeansOfType(Person.class);
        System.out.println(beansOfType);

        ConfigurableEnvironment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println("os.name->"+ property);

    }

}

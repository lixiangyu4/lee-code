package com.lixiangyu.lee.spring.source;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-02-25 15:16
 **/
public class Test {

    private ApplicationContext context;

    @Before
    public void setUp() {
        context =
            new FileSystemXmlApplicationContext("//Users/lixiangyu/phoenix/lee-code/src/main/java/com/lixiangyu/lee/spring/source/spring.xml");
    }

    @org.junit.Test
    public void test01() {
        Person person = context.getBean(Person.class);
        System.out.println(person);
    }

}

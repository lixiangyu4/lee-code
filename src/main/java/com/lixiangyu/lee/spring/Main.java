package com.lixiangyu.lee.spring;

import com.lixiangyu.lee.spring.aop.MathAdd;
import com.lixiangyu.lee.spring.config.BeanConfiguration;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2018-11-24 15:27
 **/
public class Main {

    AnnotationConfigApplicationContext annotationConfigApplicationContext
            = new AnnotationConfigApplicationContext(BeanConfiguration.class);

    @Test
    public void test01() {

        Object person = annotationConfigApplicationContext.getBean("person");
        System.out.println(person);
//        String osname = annotationConfigApplicationContext.getEnvironment().getProperty("os.name");
//        printBean();
//        System.out.println(osname);
        annotationConfigApplicationContext.close();
    }


    @Test
    public void test02() {
        MathAdd mathAdd = annotationConfigApplicationContext.getBean(MathAdd.class);
        mathAdd.add(1,2);
    }


    private void printBean() {
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String str : beanDefinitionNames) {
            System.out.println(str);
        }

    }

    @Test
    public void test03() throws IOException {
        File file = new File("/Users/lixiangyu/work/陕西德林101/会员接口.txt");
        InputStream inputStream = new FileInputStream(file);
        byte[] b = new byte[1024];
        inputStream.read(b);
        System.out.println(new String(b, "GBK"));
    }
}
